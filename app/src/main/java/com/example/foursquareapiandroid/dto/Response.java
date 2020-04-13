package com.example.foursquareapiandroid.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
        @SerializedName("categories")
        @Expose
        private List<CategoryDTO> categories = null;

        /**
         * No args constructor for use in serialization
         */
        public Response() {
        }

        /**
         * @param categories
         */
        public Response(List<CategoryDTO> categories) {
            super();
            this.categories = categories;
        }

        public List<CategoryDTO> getCategories() {
            return categories;
        }

        public void setCategories(List<CategoryDTO> categories) {
            this.categories = categories;
        }
}
