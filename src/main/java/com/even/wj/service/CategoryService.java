package com.even.wj.service;

import com.even.wj.domain.Category;
import com.even.wj.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    //获取所有书籍种类，根据id排序
    public List<Category> list() {
        return categoryMapper.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    //根据id获取书籍种类
    public Category get(int id){
        return categoryMapper.findById(id).orElse(null);
    }
}
