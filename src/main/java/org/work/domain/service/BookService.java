package org.work.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.work.domain.model.Book;
import org.work.domain.model.BookCategoryList;
import org.work.domain.model.Category;
import org.work.domain.repository.BookCategoryListRepository;
import org.work.domain.repository.BookRepository;

import java.util.List;

/**
 * Created by akiraabe on 2017/04/29.
 */
@Service
@Transactional
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BookCategoryListRepository bookCategoryListRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public List<Book> findAllSortedBy(String... fields) {
        //return bookRepository.findAll(new Sort(fields));
        return bookRepository.findAll();
    }

    public Book getOne(Long id) {
        Book book = bookRepository.getOne(id);
        book.setCategoryList(categoryService.findByBookId(book.getId()));
        return book;
    }

    public void register(Book book) {
        book.setCategoryList(categoryService.prepare(book.getCategories()));
        bookRepository.save(book);
        for (Category cat : book.getCategoryList()) {
            BookCategoryList bookCategoryList = new BookCategoryList();
            bookCategoryList.setBookId(book.getId());
            bookCategoryList.setCategoryListId(cat.getId());
            bookCategoryListRepository.save(bookCategoryList);
        }
    }

    public List<Book> findByCategoryList_name(String categoryName) {
        if (categoryName.isEmpty()) {
            return this.findAll();
        } else {
            return bookRepository.findByCategoryList_name(categoryName);
        }
    }

    public void edit(Book book) {
        //TODO:
        this.register(book);
    }

    public void remove(Long id) {
        bookRepository.delete(bookRepository.getOne(id));
    }
}
