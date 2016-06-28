/* Usuários e permissão */

INSERT INTO ROLE VALUES('ROLE_ADMIN');
INSERT INTO ROLE VALUES('ROLE_COMPRADOR');

INSERT INTO USER(LOGIN,NAME,PASSWORD)
  VALUES('comprador@gmail.com',
         'Alberto',
         /* Senha 123 */
         '$2a$08$UUZM4/1nNkGQBhvmDhW7VOfAogor9SUoUpnX3MDvN7QPcVWqmYK8G');
INSERT INTO USER(LOGIN,NAME,PASSWORD)
VALUES('admin@casadocodigo.com.br',
       'Administrador',
       /* Senha 123456 */
       '$2a$08$Sa40JueH3zsGFT./8JnDzuTKLDa228AtUMUL6WoH/hyCDY5e.YKMK');

INSERT INTO USER_ROLES(USER_LOGIN, ROLES_NAME)
  VALUES('comprador@gmail.com', 'ROLE_COMPRADOR');
INSERT INTO USER_ROLES(USER_LOGIN, ROLES_NAME)
  VALUES('admin@casadocodigo.com.br', 'ROLE_ADMIN');

/* Produtos e BOOKS PRICE */

INSERT INTO PRODUCT(DESCRIPTION, PAGES, RELEASE_DATE, SUMMARY_PATH, TITLE)
  VALUES(
    'Mais um livro sobre Java',
    250,
    SYSDATE(),
    'uploaded-images/like.png',
    'JAVAEE in Action'
  );
INSERT INTO PRODUCT(DESCRIPTION, PAGES, RELEASE_DATE, SUMMARY_PATH, TITLE)
  VALUES(
    'Muitos livros de Java',
    150,
    SYSDATE(),
    'uploaded-images/like.png',
    'Always Java'
  );
INSERT INTO PRODUCT(DESCRIPTION, PAGES, RELEASE_DATE, SUMMARY_PATH, TITLE)
  VALUES(
    'Bolevu mecie',
    1000,
    SYSDATE(),
    'uploaded-images/LogoBig.png',
    'Live in Action'
  );

INSERT INTO PRODUCT_PRICES (PRODUCT_ID, BOOK_TYPE, VALUE)
    VALUES (
      1,
      0,
      300.00
    );
INSERT INTO PRODUCT_PRICES (PRODUCT_ID, BOOK_TYPE, VALUE)
    VALUES (
      1,
      1,
      400.00
    );
INSERT INTO PRODUCT_PRICES (PRODUCT_ID, BOOK_TYPE, VALUE)
    VALUES (
      1,
      2,
      600.00
    );
