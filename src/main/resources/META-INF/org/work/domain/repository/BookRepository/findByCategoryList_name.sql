SELECT b.*
FROM
  BOOK b
INNER JOIN
  BOOK_CATEGORY_LIST bc
  ON (bc.book_id = b.id)
INNER JOIN
  CATEGORY c
  ON (c.id = bc.category_list_id)
WHERE
  c.name = /* name */'java'
;
