package com.bitc.springproject.dto;

import lombok.Data;

@Data
public class CategoryDto {

//    카테고리
    private int categoryIdx;
    private String parentCategory;
    private String categoryName;

//    말머리
    private int subCategoryIdx;
    private String subCategoryName;
}
