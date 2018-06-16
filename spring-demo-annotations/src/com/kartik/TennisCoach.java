package com.kartik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("tennisCoach") when the Bean ID is custom

@Component
public class TennisCoach implements Coach {

	// @Autowired Here also 
	private FortuneService fortuneService;

	//@Autowired // Here too
	public TennisCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}
	
	public TennisCoach() {
		super();
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Tennis practice with Sania Mirza.. hahaha!!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
