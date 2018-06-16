package com.kartik;

import org.springframework.stereotype.Component;

//@Component("tennisCoach") when the Bean ID is custom

@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Tennis practice with Sania Mirza.. hahaha!!";
	}

}
