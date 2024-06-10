-- -----------------------------------------------------
-- Schema sample_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sample_db` DEFAULT CHARACTER SET utf8 ;
USE `sample_db` ;

DROP TABLE IF EXISTS `sample_db`.`order_items` ;
DROP TABLE IF EXISTS `sample_db`.`orders` ;
DROP TABLE IF EXISTS `sample_db`.`products` ;
DROP TABLE IF EXISTS `sample_db`.`suppliers` ;
DROP TABLE IF EXISTS `sample_db`.`customers` ;

/*==============================================================*/
/* Table: customers                                             */
/*==============================================================*/
create table customers (
   id                   int             not null,
   firstName            varchar(40)     not null,
   lastName             varchar(40)     not null,
   city                 varchar(40)     null,
   country              varchar(40)     null,
   phone                varchar(20)     null,
   primary key (id)
);

/*==============================================================*/
/* Table: "Orders"                                              */
/*==============================================================*/
create table orders (
   id                   int             not null   AUTO_INCREMENT,
   orderDate            datetime             default (CURRENT_DATE) not null,
   orderNumber          varchar(10)         not null UNIQUE,
   customerId           int                  not null,
   totalAmount          decimal(12,2)        null default 0,
   primary key (id)
);

/*==============================================================*/
/* Table: OrderItems                                            */
/*==============================================================*/
create table order_items (
   id                   int                  not null AUTO_INCREMENT,
   orderid              int                  not null,
   productId            int                  not null,
   unitPrice            decimal(12,2)        not null default 0,
   quantity             int                  not null default 1,
   primary key (id)
);

/*==============================================================*/
/* Table: Products                                              */
/*==============================================================*/
create table products (
   id                   int                 not null,
   productName          varchar(50)         not null,
   supplierId           int                  not null,
   unitPrice            decimal(12,2)        null default 0,
   package              varchar(30)         null,
   discontinued       bit                  not null default 0,
   primary key (id)
);

/*==============================================================*/
/* Table: suppliers                                             */
/*==============================================================*/
create table suppliers (
   id                   int                 not null,
   companyName          varchar(40)         not null,
   contactName          varchar(50)         null,
   contactTitle         varchar(40)         null,
   city                 varchar(40)         null,
   country              varchar(40)         null,
   phone                varchar(30)         null,
   fax                  varchar(30)         null,
   primary key (id)
);

alter table orders
   add constraint FK_ORDER_REFERENCE_customers foreign key (customerId)
      references customers (id);

alter table order_items
   add constraint FK_ORDERITEM_REFERENCE_ORDERS foreign key (orderId)
      references orders (id);

alter table order_items
   add constraint FK_ORDERITEM_REFERENCE_PRODUCTS foreign key (productId)
      references products (id);

alter table products
   add constraint FK_PRODUCT_REFERENCE_SUPLIERS foreign key (supplierId)
      references suppliers (id);