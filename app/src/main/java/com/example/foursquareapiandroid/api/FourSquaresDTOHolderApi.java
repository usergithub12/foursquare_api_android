package com.example.foursquareapiandroid.api;

import com.example.foursquareapiandroid.dto.CategoryResponse;
import com.example.foursquareapiandroid.dto.Response;
import com.example.foursquareapiandroid.dto.search.SearchResponse;
import com.example.foursquareapiandroid.dto.search.VenuesResponse;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface FourSquaresDTOHolderApi {
    @GET("categories")
    public Call<CategoryResponse> getAllCategories();

    @GET("search")
    public Call<VenuesResponse> getPlaces(@QueryMap Map<String, String> options);
}
