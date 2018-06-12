package com.lee.jeson316.mydemo.okhttpdemo.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lee.jeson316.mydemo.R;
import com.lee.jeson316.mydemo.base.MyLog;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpFragment extends Fragment {
    TextView textView;
    ProgressBar pb;

    MyTask mMyTask;
    DownloadFilesTask mDownloadFilesTask;
    AsyncTask[] tasks = {mMyTask,};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_okhttp, null);
        view.findViewById(R.id.but_net_normal).setOnClickListener(new ClickforFragment());
        view.findViewById(R.id.but_rx).setOnClickListener(new ClickforFragment());
        view.findViewById(R.id.but_task).setOnClickListener(new ClickforFragment());
        view.findViewById(R.id.but_download).setOnClickListener(new ClickforFragment());
        textView = view.findViewById(R.id.tv_show_msg);
        pb = view.findViewById(R.id.pb);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMyTask != null) {
            mMyTask.cancel(false);
        }
    }

    private class ClickforFragment implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.but_net_normal:
                    MyLog.E(OkHttpFragment.this, "get");
                    new NetUtils().get();
                    break;
                case R.id.but_rx:
                    MyLog.E(OkHttpFragment.this, "post");
                    new NetUtils().post();
                    break;
                case R.id.but_task:
                    MyLog.E(OkHttpFragment.this, "upload");
                    new NetUtils().upLoad();
                    break;
                case R.id.but_download:
                    MyLog.E(OkHttpFragment.this, "download");

                    break;
                default:
                    MyLog.E(OkHttpFragment.this, "null");
            }
        }
    }


    private class NetUtils {

        public void get() {
            pb.setVisibility(View.VISIBLE);
            String url = "https://www.v2ex.com/api/topics/hot.json";
            OkHttpClient client = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.MILLISECONDS).build();
            final Request request = new Request.Builder().url(url).get().build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    if (isAdded()) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                pb.setVisibility(View.GONE);
                            }
                        });
                    }
                    pb.setVisibility(View.GONE);
                    MyLog.E(OkHttpFragment.this, e.getMessage());
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {

                    if (isAdded()) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                pb.setVisibility(View.GONE);
                                String s = "null";
                                try {
                                    s = response.body().string();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                textView.setText(s);
                            }
                        });
                    }
                }
            });
        }

        public void post() {
            pb.setVisibility(View.VISIBLE);
            Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                    String url = "https://www.v2ex.com/api/topics/hot.json";
                    OkHttpClient client = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.MILLISECONDS).build();
                    final Request request = new Request.Builder().url(url).get().build();
                    Call call = client.newCall(request);
                    Response response = call.execute();
                    observableEmitter.onNext(response.body().string());
                }
            }).observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            pb.setVisibility(View.GONE);
                            textView.setText(s);
                            MyLog.E(OkHttpFragment.this, "rx success");
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            pb.setVisibility(View.GONE);
                            MyLog.E(OkHttpFragment.this, "rx excepiton" + throwable.toString());
                        }
                    });
        }

        public void upLoad() {

            String url = "https://www.v2ex.com/api/topics/hot.json";
            mMyTask = new MyTask(url);
            mMyTask.execute();
        }

        public void downLoad() {

        }
    }

    private class MyTask extends AsyncTask<String, Integer, String> {
        String url;

        public MyTask(String url) {
            this.url = url;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            Request.Builder requestBuilder = new Request.Builder()
                    .url(url)
                    .get();
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                    .connectTimeout(400, TimeUnit.MILLISECONDS);

            OkHttpClient client = clientBuilder.build();
            Call call = client.newCall(requestBuilder.build());
            Response mResponse = null;
            try {
                mResponse = call.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                return mResponse.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "null";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pb.setVisibility(View.GONE);
            textView.setText(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

        }

    }

    private class DownloadFilesTask extends AsyncTask<URL, Integer, Long> {

        @Override
        protected Long doInBackground(URL... urls) {
            Request.Builder mRequsetBuilder = new Request.Builder();
            OkHttpClient.Builder mOkhttpBuilder = new OkHttpClient.Builder();

            Request request = mRequsetBuilder.url(urls[0]).build();

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}
