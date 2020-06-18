package com.mycafe.model;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table
@ApiModel(value = "Ürün Kategorileri Tablosu")
public class FoodCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String categoryName;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getCategoryName() { return categoryName; }

    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}
