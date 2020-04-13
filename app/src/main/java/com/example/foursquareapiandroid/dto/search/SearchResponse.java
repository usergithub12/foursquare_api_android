package com.example.foursquareapiandroid.dto.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SearchResponse {
        @SerializedName("venues")
        @Expose
        private List<Venue> venues = new ArrayList<>();

        /**
         * No args constructor for use in serialization
         *
         */
        public SearchResponse() {
        }

        /**
         *
         * @param venues
         */
        public SearchResponse(List<Venue> venues) {
            super();
            this.venues = venues;
        }

        public List<Venue> getVenues() {
            return venues;
        }

        public void setVenues(List<Venue> venues) {
            this.venues = venues;
        }

    }
