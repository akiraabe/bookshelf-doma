package org.work.domain.model;

import lombok.Data;
import lombok.ToString;
import org.seasar.doma.*;

/**
 * Created by akiraabe on 2017/05/13.
 */
@Data
@ToString
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
}
