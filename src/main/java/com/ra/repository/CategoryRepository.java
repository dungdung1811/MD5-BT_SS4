package com.ra.repository;

import com.ra.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CategoryRepository extends CrudRepository<Category,Integer> {
}
