package com.kartik;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.kartik")
@PropertySource("classpath:sports.properties")
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
