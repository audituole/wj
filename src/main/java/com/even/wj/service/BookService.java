package com.even.wj.service;

import com.even.wj.domain.Book;
import com.even.wj.domain.Category;
import com.even.wj.mapper.BookMapper;
import com.even.wj.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    CategoryService categoryService;

    //根据id查询书籍
    public List<Book> list() {
        return bookMapper.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    //新增或更新书籍
    public void addOrUpdate(Book book){
        bookMapper.save(book);
    }

    //根据id删除书籍
    public void deletebyId(int id){
        bookMapper.deleteById(id);
    }

    //获取某种类的所有图书
    public List<Book> listByCategory(int cid){
        Category category = categoryService.get(cid);
        return bookMapper.findAllByCategory(category);
    }
}
