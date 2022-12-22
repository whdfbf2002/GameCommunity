package com.bitc.springproject.mapper;

import com.bitc.springproject.dto.BoardDto;
import com.bitc.springproject.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<CategoryDto> categoryList() throws Exception;
    CategoryDto categoryBoard(int categoryIdx) throws Exception;

    List<CategoryDto> subCategoryList(int categoryIdx) throws Exception;

    List<CategoryDto> subCategory() throws Exception;
}
