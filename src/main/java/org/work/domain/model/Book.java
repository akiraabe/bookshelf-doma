package org.work.domain.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.seasar.doma.*;
import org.work.app.form.BookForm;

import java.util.Date;
import java.util.List;

/**
 * Created by akiraabe on 2017/04/29.
 */
@Data
@ToString
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    private String publisher;
    private String author;
//    @Temporal(value = TemporalType.DATE)
    private Date publishDate;
    //@OneToMany
    @Transient
    private List<Category> categoryList;
    @Transient
    private String categories;
    @Version
    private Long version;

    public Book(BookForm form) {
        this.id = form.getId();
        this.title = form.getTitle();
        this.publisher = form.getPublisher();
        this.author = form.getAuthor();
        this.publishDate = form.getPublishDate();
        this.categories = form.getCategories();
        this.version = form.getVersion();
    }

    public Book() {
    }

    public Book(String title, String publisher, String author, Date publishDate) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String getCategories() {
        if (this.categoryList == null) {
            return this.categories;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Category category : this.categoryList) {
            sb.append(category.getName());
            if (i != this.categoryList.size()-1) {
                sb.append(", ");
            }
            i++;
        }
        return sb.toString();
    }
}
