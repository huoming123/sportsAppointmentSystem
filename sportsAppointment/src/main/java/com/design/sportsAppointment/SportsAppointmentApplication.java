package com.design.sportsAppointment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.design.sportsAppointment.mapper")
@ComponentScan(value="com.design")
@SpringBootApplication
public class SportsAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsAppointmentApplication.class, args);
	}

}
