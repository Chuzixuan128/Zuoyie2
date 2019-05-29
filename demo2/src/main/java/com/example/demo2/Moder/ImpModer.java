package com.example.demo2.Moder;

import android.util.Log;

import com.example.demo2.Bean;
import com.example.demo2.CallBeack.CallBeack;
import com.example.demo2.MyApi;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpModer implements Moder {
    private static final String TAG = "ImpModer";
    @Override
    public void getData(final CallBeack callBeack) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.Url1)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MyApi myApi = retrofit.create(MyApi.class);
        Observable<Bean> data = myApi.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG,"onSubscribe"+d);
                    }

                    @Override
                    public void onNext(Bean bean) {
                            callBeack.Chenggong(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,"onError"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
