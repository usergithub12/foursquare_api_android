package com.example.foursquareapiandroid.dto.search;

import com.example.foursquareapiandroid.dto.CategoryDTO;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Venue {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("categories")
    @Expose
    private List<CategoryDTO> categories = null;


    /**
     * No args constructor for use in serialization
     *
     */
    public Venue() {
    }

    /**
     *
     * @param name
     * @param location
     * @param id
     * @param categories
     */
    public Venue(String id, String name, Location location, List<CategoryDTO> categories) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.categories = categories;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", categories=" + categories +
                '}';
    }
}