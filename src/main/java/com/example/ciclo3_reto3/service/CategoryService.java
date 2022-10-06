package com.example.ciclo3_reto3.service;

import com.example.ciclo3_reto3.entities.Category;
import com.example.ciclo3_reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if(e.isPresent()){
                return category;
            }else{
                return categoryRepository.save(category);
            }
        }
    }
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g= categoryRepository.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return categoryRepository.save(g.get());
            }
        }
        return category;
    }
    public boolean deleteCategory(int id){
        boolean d = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;

    }
}
