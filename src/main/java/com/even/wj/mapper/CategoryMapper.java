package com.even.wj.mapper;

import com.even.wj.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMapper extends JpaRepository<Category, Integer> {
}
