package com.kartik;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// Read Spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);
		// Get the bean
		Coach coach = context.getBean("swimCoach", Coach.class);
		// Methods of Bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		// Close the context
		context.close();

	}

}
