CREATE TABLE if not exists book
(
  id bigint NOT NULL AUTO_INCREMENT,
  author varchar(255),
  publishdate date,
  publisher varchar(255),
  title varchar(255),
  version  bigint,
  CONSTRAINT book_pkey PRIMARY KEY (id)
);

CREATE TABLE if not exists category
(
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(255),
  CONSTRAINT category_pkey PRIMARY KEY (id)
);

CREATE TABLE if not exists book_category_list
(
  book_id bigint NOT NULL,
  category_list_id bigint NOT NULL,
  CONSTRAINT fk_const_to_book1 FOREIGN KEY (book_id)
  REFERENCES book (id)
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_const_to_category1 FOREIGN KEY (category_list_id)
  REFERENCES category (id)
  ON UPDATE NO ACTION ON DELETE NO ACTION
);