package me.musclegeeker.sell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 商品栏目
 */
@Data
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
