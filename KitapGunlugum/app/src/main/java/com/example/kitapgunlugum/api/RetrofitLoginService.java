package com.example.kitapgunlugum.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitLoginService {

    @POST("login/")
    Call<LoginResponse> loginResponseCall(@Body LoginInfo loginInfo);
    @GET("user/")
    Call<UserResponse> userResonseCall(@Header("Authorization") String token);

}
