package org.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.work.domain.model.Book;
import org.work.domain.repository.BookRepository;
import org.work.domain.service.BookService;
import org.work.domain.service.CategoryService;
import org.work.util.DateUtils;

/**
 * DatabaseLoader.
 * <pre>
 *     Loading demo data to database before app running.
 *     It implements Spring Boot’s CommandLineRunner so that it gets run after all the beans are created and registered.
 * </pre>
 * Created by akiraabe on 2017/05/07.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private final BookService bookService;
    @Autowired
    private final CategoryService categoryService;

    public DatabaseLoader(BookService service, CategoryService categoryService) {
        this.bookService = service;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... strings) throws Exception {
        if (this.bookService.findAll().size() == 0) {
            this.bookService.register(new Book("Domain Driven Design", "Addison-Wesley Professional", "Eric Evans", DateUtils.parse("2003-08-22")));
            this.bookService.register(new Book("Patterns of Enterprise Application Architecture", "Addison-Wesley Professional", "Martin Fowler", DateUtils.parse("2002-11-05")));

            Book django = new Book("Django X python", "技術評論社", "露木 誠", DateUtils.parse("2009-03-10"));
            django.setCategoryList(categoryService.prepare("django,python,web"));
            this.bookService.register(django);

            Book minnanoPython = new Book("みんなのPython", "Softbank pub.", "A.Shibata", null);
            minnanoPython.setCategoryList(categoryService.prepare("python,入門"));
            this.bookService.register(minnanoPython);
        }

//        for (Book book : this.bookRepository.findByCategoryList_name("入門")) {
//            System.out.println(book.getTitle());
//        }
    }
}
