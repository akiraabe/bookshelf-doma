package org.work.domain.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;


/**
 * Created by akiraabe on 2017/04/29.
 */
public class BookTest {

    @Test
    public void testNormalCase() {

        Book book = new Book();
        book.setId(1L);
        book.setTitle("Domain Driven Design");
        book.setAuthor("Eric Evans");
        book.setPublisher("ORAILEY");
        book.setPublishDate(null);

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(book.getId()).as("case1 id").isEqualTo(1L);
        softly.assertThat(book.getTitle()).as("case2 title").isEqualTo("Domain Driven Design");
        softly.assertThat(book.getAuthor()).as("case3 author").isEqualTo("Eric Evans");
        softly.assertAll();
    }

}
