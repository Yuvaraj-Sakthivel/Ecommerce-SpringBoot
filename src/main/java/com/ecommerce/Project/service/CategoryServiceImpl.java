package com.ecommerce.Project.service;

import com.ecommerce.Project.exceptions.APIException;
import com.ecommerce.Project.exceptions.ResourceNotFoundException;
import com.ecommerce.Project.model.Category;
import com.ecommerce.Project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category>categories=categoryRepository.findAll();
        if (categories.isEmpty())
            throw new APIException("No category created till now");
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory =categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null)
            throw new APIException("Category with name "+category.getCategoryName()+" already exists...!");
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryId));
        categoryRepository.delete(existingCategory);
        return "Category id"+categoryId+"deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryId));
        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;
    }
}
