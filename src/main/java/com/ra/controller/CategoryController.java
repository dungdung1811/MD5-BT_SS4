package com.ra.controller;
import com.ra.entity.Category;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> list = categoryService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Category> findById(@PathVariable("id") Integer id){
        Category category = categoryService.findById(id);
        if (category == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(category,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category){
        Category categoryNew = categoryService.save(category);
        if (categoryNew == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(category,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Category> update(@PathVariable ("id") Integer id, @RequestBody Category category){
        if(categoryService.findById(id) == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Category categoryNew = categoryService.save(category);
        return  new ResponseEntity<>(categoryNew, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id")Integer id){
        if (categoryService.findById(id)!= null){
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}

