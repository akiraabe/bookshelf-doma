package org.work.domain.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.work.domain.model.Book;
import org.work.domain.model.BookCategoryList;

import java.util.List;

/**
 * Created by akiraabe on 2017/06/03.
 */
@Dao
@ConfigAutowireable
public interface BookCategoryListRepository {

    @Select
    List<BookCategoryList> findByBookId(Long bookId);

    @Insert
    int save(BookCategoryList bookCategoryList);

    @Delete
    int delete(BookCategoryList bookCategoryList);
}
