package com.bitc.springproject.service;

import com.bitc.springproject.dto.BoardDto;
import com.bitc.springproject.dto.CategoryDto;
import com.bitc.springproject.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    public CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> categoryList() throws Exception {
        return categoryMapper.categoryList();
    }

    @Override
    public CategoryDto categoryBoard(int categoryIdx) throws Exception {
        CategoryDto categoryBoard = categoryMapper.categoryBoard(categoryIdx);
        return categoryBoard;
    }

    @Override
    public List<CategoryDto> subCategoryList(int categoryIdx) throws Exception {
        return categoryMapper.subCategoryList(categoryIdx);
    }

    @Override
    public List<CategoryDto> subCategory() throws Exception {
        return categoryMapper.subCategory();
    }


}
