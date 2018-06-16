package com.kartik;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.kartik")
public class SportsConfig {
	
	@Bean
	public FortuneService fortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		SwimCoach coach = new SwimCoach(fortuneService());
		return coach;
	}
}
