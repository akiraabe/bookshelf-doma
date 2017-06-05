package org.work.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.work.domain.model.BookCategoryList;
import org.work.domain.model.Category;
import org.work.domain.repository.BookCategoryListRepository;
import org.work.domain.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akiraabe on 2017/04/29.
 */
@Service
@Transactional
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookCategoryListRepository bookCategoryListRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category getOne(Long id) {
        return categoryRepository.getOne(id);
    }

    public void register(Category category) {
        categoryRepository.save(category);
    }

    /**
     *
     * @param categories
     * @return
     */
    public List<Category> prepare(String categories) {

        List<Category> categoryList = new ArrayList<>();
        if (StringUtils.isEmpty(categories)) { // avoid NPE.
            return categoryList;
        }
        for (String category : categories.split(",")) {
            Category catFromRepo = categoryRepository.findByName(category.toLowerCase().trim());
            System.out.println("catFromRepo : " + catFromRepo);
            if (catFromRepo == null) {
                catFromRepo = new Category(category.toLowerCase().trim());
                categoryRepository.save(catFromRepo);
            }
            categoryList.add(catFromRepo);
        }
        return categoryList;
    }

    public List<Category> findByBookId(Long id) {
        List<BookCategoryList> bookCategoryList = bookCategoryListRepository.findByBookId(id);
        List<Category> categoryList = new ArrayList<>();
        for (BookCategoryList bcl : bookCategoryList) {
            categoryList.add(categoryRepository.getOne(bcl.getCategoryListId()));
        }
        return categoryList;
    }
}
