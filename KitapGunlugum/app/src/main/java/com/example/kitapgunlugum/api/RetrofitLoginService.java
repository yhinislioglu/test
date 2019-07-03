package com.example.kitapgunlugum.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitLoginService {

    String BASE_URL = "http://62.248.59.168:8623/";

    @POST("api/rest-auth/login/")
    Call<LoginResponse> loginResponseCall(@Body LoginInfo loginInfo);
    @GET("api/rest-auth/user/")
    Call<UserResponse> userResonseCall(@Header("Authorization") String token);
    @GET("api/edu/instance/")
    Call<MyBookResponse> myBookResponseCall(@Header("Authorization") String token);

}
