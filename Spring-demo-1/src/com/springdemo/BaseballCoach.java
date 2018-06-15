package com.springdemo;

public class BaseballCoach implements Coach {
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in batting";
	}
	//Hello
	//ss
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
