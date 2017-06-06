package org.work.domain.model;

import lombok.Data;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * Created by sarah on 2017-06-03.
 */
@Data
@ToString
@Entity
@Table(name = "book_category_list")
public class BookCategoryList {

    public BookCategoryList() {}

    public BookCategoryList(Long bookId, Long categoryListId) {
        this.bookId = bookId;
        this.categoryListId = categoryListId;
    }

    @Id
    @Column(name = "book_id")
    private Long bookId;
    @Id
    @Column(name = "category_list_id")
    private Long categoryListId;
}
