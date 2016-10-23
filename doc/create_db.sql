
/*Create CUSTOMER table*/

CREATE TABLE CUSTOMER
(
  EMAIL VARCHAR2(50) 
  , PASSWORD VARCHAR2(100)
  , CUSTOMER_NAME VARCHAR2(40)
  , MOBILE NUMBER(11) NOT NULL
  , BALANCE NUMBER(6) NOT NULL
  , LOYALTY CHAR check (LOYALTY in('Y','N'))

  , CONSTRAINT CUSTOMER_PK PRIMARY KEY
    (
      EMAIL
    )
    ENABLE
  );

/*Create ADMIN table*/

CREATE TABLE ADMIN
(
  EMAIL VARCHAR2(50) 
  , PASSWORD VARCHAR2(100)
  , ADMIN_NAME VARCHAR2(40)
  , MOBILE NUMBER(11) NOT NULL

  , CONSTRAINT ADMIN_PK PRIMARY KEY
    (
      EMAIL
    )
    ENABLE
  );

/*Create ADDRESS table*/

CREATE TABLE ADDRESS
(
  EMAIL VARCHAR2(50) 
  , POSTAL_CODE NUMBER(4) NOT NULL
  , CITY VARCHAR2(30)
  , STREET VARCHAR2(20)
  , HOUSE_NUMBER NUMBER(3) NOT NULL
  , CONSTRAINT ADDRESS_PK PRIMARY KEY
    (
      POSTAL_CODE
    )
    ENABLE
  );

/*Set foreign keys in ADDRESS table*/

  ALTER TABLE ADDRESS
  ADD CONSTRAINT EMAIL FOREIGN KEY
  (
    EMAIL
  )
  REFERENCES CUSTOMER
  (
    EMAIL
  )
  ON DELETE CASCADE ENABLE;

/*Create CATEGORY table*/

CREATE TABLE CATEGORY
(
  CATEGORY_ID NUMBER(5)
, CATEGORY_NAME VARCHAR2(20)
, CONSTRAINT CATEGORY_PK PRIMARY KEY
  (
    CATEGORY_ID
  )
);

/*Create PRODUCT table*/

CREATE TABLE PRODUCT
(
  PRODUCT_ID NUMBER(5)
, CATEGORY_ID NUMBER(5) NOT NULL
, PRODUCT_NAME VARCHAR2(40)
, DESCRIPTION VARCHAR(300)
, PRICE NUMBER(6) NOT NULL
, AMOUNT NUMBER(3) NOT NULL
, TIME DATE
, CONSTRAINT PRODUCT_ID_PK PRIMARY KEY
  (
  PRODUCT_ID
  )
);

/*Set foreign keys in PRODUCT table*/

ALTER TABLE PRODUCT
ADD CONSTRAINT CATEGORY_ID FOREIGN KEY
(
  CATEGORY_ID
)
REFERENCES CATEGORY
(
  CATEGORY_ID
)
ON DELETE CASCADE ENABLE;

/*Create ORDERING table*/

CREATE TABLE ORDERING
(
  ORDERING_ID NUMBER(5)
, EMAIL VARCHAR2(50)
, TIME DATE
, SUM_PRICE NUMBER(6) NOT NULL
, CONSTRAINT ORDERING_PK PRIMARY KEY
  (
    ORDERING_ID
  )
  ENABLE
);

/*Set foreign keys in ORDERING table*/

ALTER TABLE ORDERING
ADD CONSTRAINT EMAIL_FK FOREIGN KEY
(
  EMAIL
)
REFERENCES CUSTOMER
(
  EMAIL
)
ON DELETE CASCADE ENABLE;

/*Create INVOICE table*/

CREATE TABLE INVOICE
(
  INVOICE_ID NUMBER(5)
, ORDERING_ID NUMBER(5)
, PRODUCT_ID NUMBER(5)
, DB NUMBER(3) NOT NULL
, PRODUCT_PRICE NUMBER(6) NOT NULL
, CONSTRAINT INVOICE_PK PRIMARY KEY
  (
    INVOICE_ID
  )
  ENABLE
);

/*Set foregin keys in INVOICE table*/

ALTER TABLE INVOICE
ADD CONSTRAINT ORDERING_FK FOREIGN KEY
(
  ORDERING_ID
)
REFERENCES ORDERING
(
  ORDERING_ID
)
ON DELETE CASCADE ENABLE;

ALTER TABLE INVOICE
ADD CONSTRAINT PRODUCT_FK FOREIGN KEY
(
  PRODUCT_ID
)
REFERENCES PRODUCT
(
  PRODUCT_ID
)
ON DELETE CASCADE ENABLE;

/*Create COMMENTARY table*/

CREATE TABLE COMMENTARY
(
  COMMENT_ID NUMBER(5)
, PRODUCT_ID NUMBER(5)
, TIME DATE
, TEXT VARCHAR2(100)
, CONSTRAINT COMMENTARY_PK PRIMARY KEY
  (
    COMMENT_ID
  )
  ENABLE
);

/*Set foreign keys in COMMENT table*/

ALTER TABLE COMMENTARY
ADD CONSTRAINT PRODUCT_ID_FK FOREIGN KEY
(
  PRODUCT_ID
)
REFERENCES PRODUCT
(
  PRODUCT_ID
)
ON DELETE CASCADE ENABLE;





