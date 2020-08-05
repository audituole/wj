package com.even.wj.mapper;

import com.even.wj.domain.Book;
import com.even.wj.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookMapper extends JpaRepository<Book, Integer> {

    //获取某种类下的所有图书
    List<Book> findAllByCategory(Category category);


    List<Book> findAllByTitleLikeOrAuthorLike(String keyWord1, String keyWord2);
}
