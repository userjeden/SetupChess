package com.capgemini.chess;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.capgemini.chess.exceptions.NoSuchUserException;


@EnableScheduling
@SpringBootApplication
public class ChessApplication {

	public static void main(String[] args) throws BeansException, NoSuchUserException {
		SpringApplication.run(ChessApplication.class, args);
		
	}
}
