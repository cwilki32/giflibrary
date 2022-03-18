package com.detroitlabs.giflibrary.controller;

import com.detroitlabs.giflibrary.data.CategoryRepository;
import com.detroitlabs.giflibrary.data.GifRepository;
import com.detroitlabs.giflibrary.model.Category;
import com.detroitlabs.giflibrary.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String displayCategories(ModelMap modelMap) {
        for (Category category : categoryRepository.getAllCategories()) { //gets all the items of the All_Categories
            modelMap.put("categories", categoryRepository.getAllCategories()); //key-value pair
        }
        return "categories"; //returns this template id
    }

    @RequestMapping("/category/{id}")
    public String categoryId(@PathVariable int id, ModelMap modelMap) {
        Category category = categoryRepository.findById(id); //searches all categories to find by id
        modelMap.put("category", category); //adds item to model map
        List<Gif> gifsByCategory = gifRepository.findById(id); //searches all gifs by id
        modelMap.put("gifsByCategory", gifsByCategory); //adds item to model map, key-value pair
        return "category"; //returns this template id
    }
}
