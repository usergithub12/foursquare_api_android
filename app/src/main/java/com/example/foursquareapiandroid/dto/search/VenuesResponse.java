package com.example.foursquareapiandroid.dto.search;

import com.example.foursquareapiandroid.dto.Meta;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VenuesResponse {
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("response")
    @Expose
    private SearchResponse response;

    /**
     * No args constructor for use in serialization
     */
    public VenuesResponse() {
    }

    /**
     * @param meta
     * @param response
     */
    public VenuesResponse(Meta meta, SearchResponse response) {
        super();
        this.meta = meta;
        this.response = response;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public SearchResponse getResponse() {
        return response;
    }

    public void setResponse(SearchResponse response) {
        this.response = response;
    }
}
