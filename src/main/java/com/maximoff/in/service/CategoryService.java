package com.maximoff.in.service;

import com.maximoff.in.model.Category;
import com.maximoff.in.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory()
    {
        return categoryRepository.findAll();
    }
    public void addCategory(Category category)
    {
        categoryRepository.save(category);
    }
    public void deleteCategoryById(int id)
    {
        categoryRepository.deleteById(id);
    }
    public Optional<Category> getCategoryById(int id)
    {
        return categoryRepository.findById(id);
    }

}
