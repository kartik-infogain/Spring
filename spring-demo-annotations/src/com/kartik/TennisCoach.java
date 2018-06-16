package com.kartik;

import org.springframework.stereotype.Component;

@Component("tennisCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Tennis practice with Sania Mirza.. hahaha!!";
	}

}
