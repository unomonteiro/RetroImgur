package io.monteirodev.retroimgur.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    public static Imgur.Auth getAuthedApi(){

        // include the access_token in the request
        // adding a header
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request authed = chain.request()
                                .newBuilder()
                                .addHeader("Authorization", "Bearer " + OAuthUtil.get(OAuthUtil.ACCESS_TOKEN))
                                .build();
                        return chain.proceed(authed);
                    }
                }).build();


        return new Retrofit.Builder()
                .baseUrl(Imgur.IMGUR_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Imgur.Auth.class);
    }

    public static Imgur.Anon getAnonApi(){

        // include the access_token in the request
        // adding a header
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request anon = chain.request()
                                .newBuilder()
                                .addHeader("Authorization", "Client-ID " + Imgur.IMGUR_CLIENT_ID)
                                .build();
                        return chain.proceed(anon);
                    }
                }).build();


        return new Retrofit.Builder()
                .baseUrl(Imgur.IMGUR_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Imgur.Anon.class);
    }
}
