package ru.Belov.LastProject3;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LastProject3Application {

	public static void main(String[] args) {
		SpringApplication.run(LastProject3Application.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
/*
create table Requests(
    ID integer AUTO_INCREMENT PRIMARY KEY ,
    BANNER_ID integer ,
    USER_AGENT TEXT,
    IP_ADDRESS varchar(255),
    DATE DATETIME,
    FOREIGN KEY (BANNER_ID)  REFERENCES Banner (ID)
);

create table Banner(
    ID integer primary key auto_increment,
    NAME VARCHAR(255),
    PRICE DECIMAL(8,2),
    CATEGORY_ID integer,
    CONTENT TEXT,
    DELETED BOOLEAN,
    FOREIGN KEY (CATEGORY_ID)  REFERENCES Category (ID)
    );

create table Category(
    ID integer primary key auto_increment,
    NAME VARCHAR(255),
    REQ_NAME VARCHAR(255),
    DELETED BOOLEAN
);
* */
