package com.example.foursquareapiandroid.api;

import com.example.foursquareapiandroid.api.interceptors.AuthUserlessInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FourSquaresApiService {

    private static FourSquaresApiService mInstance;

    private static final String BASE_URL = "https://api.foursquare.com/v2/venues/";

    private Retrofit mRetrofit;

    private FourSquaresApiService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
//                .readTimeout(60, TimeUnit.SECONDS)
//                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(new AuthUserlessInterceptor());


    //    +"?client_id="+CLIENT_ID+"&client_secret="+CLIENT_SECRET+"/"

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public static FourSquaresApiService getInstance() {
        if (mInstance == null) {
            mInstance = new FourSquaresApiService();
        }
        return mInstance;
    }

    public FourSquaresDTOHolderApi getJSONApi() {
        return mRetrofit.create(FourSquaresDTOHolderApi.class);
    }
}
