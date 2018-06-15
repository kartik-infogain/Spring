package com.springdemo;

public class BaseballCoach implements Coach {
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in batting";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
