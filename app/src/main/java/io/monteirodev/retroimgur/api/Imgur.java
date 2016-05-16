package io.monteirodev.retroimgur.api;

import java.util.ArrayList;

import io.monteirodev.retroimgur.BuildConfig;
import io.monteirodev.retroimgur.model.Basic;
import io.monteirodev.retroimgur.model.Image;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface Imgur {

    String IMGUR_BASE_URL = "https://api.imgur.com";
    String IMGUR_CLIENT_ID = BuildConfig.IMGUR_ID;
    String AUTHORIZATION_URL = "https://api.imgur.com/oauth2/authorize?client_id=" +
            IMGUR_CLIENT_ID + "&response_type=token";
    String REDIRECT_URL = "https://monteirodev:88";

    // sub interface that requires Auth
    interface Auth {
        @GET("3/account/{username}/images/{page}")
        Call<Basic<ArrayList<Image>>> images(@Path("username") String username,
                                             @Path("page") int page);
        @Multipart
        @POST("3/upload")
        Call<Basic<Image>> uploadImage(@Part("image") RequestBody image);
    }

    interface Anon {
        @Multipart
        @POST("3/upload")
        Call<Basic<Image>> uploadImage(@Part("image") RequestBody image);
    }
}
