create table hibernate_sequence (
                                    next_val bigint
);

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE app_user (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      password varchar(64) not null,
                      username varchar(64) not null unique,
                      PRIMARY KEY (id)
);

CREATE TABLE tasks (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      title varchar(64) not null,
                      completed BOOLEAN NOT NULL,
                      PRIMARY KEY (id)
);