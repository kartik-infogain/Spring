package com.kartik;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// Read Spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Get the bean
		Coach coach = context.getBean("tennisCoach", Coach.class);
		// Methods of Bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		// Close the context
		context.close();
	}

}
