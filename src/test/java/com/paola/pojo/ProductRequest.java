package com.paola.pojo;

import org.checkerframework.checker.units.qual.A;

import java.util.List;

public class ProductRequest {

    // Deserialization Process

    private String title;
    private Integer price;
    private String description;
    private Integer categoryId;
    private List<String> images;

    // no arg Constructor
    public ProductRequest(){}

    // arg Constructor
    public ProductRequest(String title, Integer price, String description, Integer categoryId, List<String> images) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getImages() {
        return images;
    }
    public void setImages(List<String> images) {
        this.images = images;
    }
}
