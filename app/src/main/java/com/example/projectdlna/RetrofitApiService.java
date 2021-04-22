package com.example.projectdlna;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author : J-T
 * date   : 2021/4/22
 * desc   :
 */
public interface RetrofitApiService {
    @GET("banner/json")
    Observable<ResponModel<List<BannerBean>>> getBanner();
}
