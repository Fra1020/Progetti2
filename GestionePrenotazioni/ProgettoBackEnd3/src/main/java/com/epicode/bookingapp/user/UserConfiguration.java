package com.epicode.bookingapp.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

	@Bean("user1")
	public User newUser1() {
		return new User("Mario","Mario Rossi","MarioRossi@gmail.com");
	}
	@Bean("user2")
	public User newUser2() {
		return new User("Gianni","Gianni bianchi","Giannibianchi@gmail.com");
	}
	@Bean("user3")
	public User newUser3() {
		return new User("Marco","Marco Verdi","MarcoVerdi@gmail.com");
	}
}
