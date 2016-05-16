package io.monteirodev.retroimgur.api;

import io.monteirodev.retroimgur.BuildConfig;

public interface Imgur {

    String IMGUR_BASE_URL = "https://api.imgur.com";
    String IMGUR_CLIENT_ID = BuildConfig.IMGUR_ID;
    String AUTHORIZATION_URL = "https://api.imgur.com/oauth2authrize?client_id=" +
            IMGUR_CLIENT_ID + "&response_type=token";
    String REDIRECT_URL = "https://redirecturl:88";
}
