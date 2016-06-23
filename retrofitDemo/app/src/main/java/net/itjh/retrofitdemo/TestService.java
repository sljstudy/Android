package net.itjh.retrofitdemo;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TestService {
  @GET("util/verifyCode/{phone}/{code}")
  Call<ResponseEntity> verifyCode(@Path("phone") String phone, @Path("code") String code);
}