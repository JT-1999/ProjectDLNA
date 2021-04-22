package com.example.projectdlna;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.youth.banner.Banner;

import java.util.List;
import java.util.function.Consumer;

import io.reactivex.schedulers.Schedulers;

/**
 * @author : J-T
 * date   : 2021/4/22
 * desc   :
 */
public class MainViewModel extends BaseViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public MutableLiveData<List<BannerBean>> getBanners(){
        final MutableLiveData<List<Banner>> liveData=new MutableLiveData<>();
        RetrofitManager.getApiService().getBanner()
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponModel<List<BannerBean>>>(){

                           }

                )
    }
}
