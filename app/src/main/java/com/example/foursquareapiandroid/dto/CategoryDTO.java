package com.example.foursquareapiandroid.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryDTO {


        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("pluralName")
        @Expose
        private String pluralName;
        @SerializedName("shortName")
        @Expose
        private String shortName;
        @SerializedName("icon")
        @Expose
        private Icon icon;

        /**
         * No args constructor for use in serialization
         */
        public CategoryDTO() {
        }

        /**
         * @param pluralName
         * @param name
         * @param icon
         * @param id
         * @param shortName
         */
        public CategoryDTO(String id, String name, String pluralName, String shortName, Icon icon) {
            super();
            this.id = id;
            this.name = name;
            this.pluralName = pluralName;
            this.shortName = shortName;
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPluralName() {
            return pluralName;
        }

        public void setPluralName(String pluralName) {
            this.pluralName = pluralName;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public Icon getIcon() {
            return icon;
        }

        public void setIcon(Icon icon) {
            this.icon = icon;
        }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pluralName='" + pluralName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", icon=" + icon +
                '}';
    }
}
