create table account (id bigint not null auto_increment, password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table category (id bigint not null auto_increment, description varchar(255), name varchar(255), parent_id bigint, primary key (id)) engine=InnoDB;
create table color (id bigint not null auto_increment, hex_code varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table comment (id bigint not null auto_increment, content varchar(255), created_date datetime, parent_id bigint, primary key (id)) engine=InnoDB;
create table material (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table product (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table product_detail (id bigint not null auto_increment, name varchar(255), price double precision, primary key (id)) engine=InnoDB;
create table role (id bigint not null auto_increment, description varchar(255), role_name varchar(255), primary key (id)) engine=InnoDB;
create table size (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table tag (id bigint not null auto_increment, code varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table user_info (id bigint not null auto_increment, fullname varchar(255), image varchar(255), primary key (id)) engine=InnoDB;
create table account (id bigint not null auto_increment, password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table category (id bigint not null auto_increment, description varchar(255), name varchar(255), parent_id bigint, primary key (id)) engine=InnoDB;
create table color (id bigint not null auto_increment, hex_code varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table comment (id bigint not null auto_increment, content varchar(255), created_date datetime, parent_id bigint, primary key (id)) engine=InnoDB;
create table material (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table product (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table product_detail (id bigint not null auto_increment, name varchar(255), price double precision, primary key (id)) engine=InnoDB;
create table role (id bigint not null auto_increment, description varchar(255), role_name varchar(255), primary key (id)) engine=InnoDB;
create table size (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table tag (id bigint not null auto_increment, code varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table user_info (id bigint not null auto_increment, fullname varchar(255), image varchar(255), primary key (id)) engine=InnoDB;
create table account (id bigint not null auto_increment, password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table category (id bigint not null auto_increment, description varchar(255), name varchar(255), parent_id bigint, primary key (id)) engine=InnoDB;
create table color (id bigint not null auto_increment, hex_code varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table comment (id bigint not null auto_increment, content varchar(255), created_date datetime, parent_id bigint, primary key (id)) engine=InnoDB;
create table material (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table product (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table product_detail (id bigint not null auto_increment, name varchar(255), price double precision, primary key (id)) engine=InnoDB;
create table role (id bigint not null auto_increment, description varchar(255), role_name varchar(255), primary key (id)) engine=InnoDB;
create table size (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table tag (id bigint not null auto_increment, code varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table user_info (id bigint not null auto_increment, fullname varchar(255), image varchar(255), primary key (id)) engine=InnoDB;
create table account (id bigint not null auto_increment, password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table category (id bigint not null auto_increment, description varchar(255), name varchar(255), parent_id bigint, primary key (id)) engine=InnoDB;
create table color (id bigint not null auto_increment, hex_code varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table comment (id bigint not null auto_increment, content varchar(255), created_date datetime, parent_id bigint, primary key (id)) engine=InnoDB;
create table material (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table product (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table product_detail (id bigint not null auto_increment, name varchar(255), price double precision, primary key (id)) engine=InnoDB;
create table role (id bigint not null auto_increment, description varchar(255), role_name varchar(255), primary key (id)) engine=InnoDB;
create table size (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table tag (id bigint not null auto_increment, code varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table user_info (id bigint not null auto_increment, fullname varchar(255), image varchar(255), primary key (id)) engine=InnoDB;
create table account (id bigint not null auto_increment, password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table category (id bigint not null auto_increment, description varchar(255), name varchar(255), parent_id bigint, primary key (id)) engine=InnoDB;
create table color (id bigint not null auto_increment, hex_code varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table comment (id bigint not null auto_increment, content varchar(255), created_date datetime, parent_id bigint, primary key (id)) engine=InnoDB;
create table material (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table product (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table product_detail (id bigint not null auto_increment, name varchar(255), price double precision, primary key (id)) engine=InnoDB;
create table role (id bigint not null auto_increment, description varchar(255), role_name varchar(255), primary key (id)) engine=InnoDB;
create table size (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table tag (id bigint not null auto_increment, code varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table user_info (id bigint not null auto_increment, fullname varchar(255), image varchar(255), primary key (id)) engine=InnoDB;
