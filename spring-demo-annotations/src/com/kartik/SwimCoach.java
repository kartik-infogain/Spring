<<<<<<< HEAD
package com.kartik;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	@Value("${email}")
	private String email;
	@Value("${team}")
	private String team;

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

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
=======
package com.kartik;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	@Value("${email}")
	private String email;
	@Value("${team}")
	private String team;

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

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
>>>>>>> ee61d503e6b3e08da756937c30fc01d282638335
