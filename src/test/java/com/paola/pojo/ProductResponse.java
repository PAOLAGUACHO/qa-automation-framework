package com.paola.pojo;

import java.util.List;

public class ProductResponse {

    private Integer id;
    private String title;
    private Integer price;
    private String description;
    private Category category;
    private List<String> images;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getImages() {
        return images;
    }

    public static class Category{
        private Integer id;
        public Integer getId() {
            return id;
        }
    }
}
