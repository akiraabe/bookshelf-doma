package org.work.domain.repository;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.data.domain.Sort;
import org.work.domain.model.Book;

import java.util.List;

/**
 * Created by akiraabe on 2017/04/29.
 */
@Dao
@ConfigAutowireable
public interface BookRepository {

    @Select
    List<Book> findByCategoryList_name(String name);

    @Select
    List<Book> findAll();

    //TODO:
//    @Select
//    List<Book> findAll(Sort orders);

    @Select
    Book getOne(Long id);

    @Insert
    int save(Book book);

    @Update
    int update(Book book);

    @Delete
    int delete(Book book);
}
