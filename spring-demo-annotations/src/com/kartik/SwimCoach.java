package com.kartik;

public class SwimCoach implements Coach {

	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim daily";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return this.fortuneService.getFortune();
	}

}
