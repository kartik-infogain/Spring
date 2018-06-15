package com.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "30 minutes of track workout daily";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do it : " + this.fortuneService.getFortune();
	}

	public TrackCoach() {
		super();
	}

	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

}
