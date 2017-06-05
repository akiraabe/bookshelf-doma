package org.work.domain.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.work.domain.model.Category;

import java.util.List;

/**
 * Created by akiraabe on 2017/05/13.
 */
@Dao
@ConfigAutowireable
public interface CategoryRepository {
    @Select
    Category findByName(String cat);

    @Select
    List<Category> findAll();

    @Select
    Category getOne(Long id);

    @Insert
    int save(Category category);
}
