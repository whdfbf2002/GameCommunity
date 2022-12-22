package com.bitc.springproject.service;

import com.bitc.springproject.dto.BoardDto;
import com.bitc.springproject.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    // 사이드바 카테고리
    List<CategoryDto> categoryList() throws Exception;

    // 게시판 카테고리 선택
    CategoryDto categoryBoard(int categoryIdx) throws Exception;

    List<CategoryDto> subCategoryList(int categoryIdx) throws Exception;

    List<CategoryDto> subCategory() throws Exception;
}
