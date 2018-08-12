<<<<<<< HEAD
package com.kartik;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// Read Spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);
		// Get the bean
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		// Methods of Bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println("Email : " + coach.getEmail());
		System.out.println("Team : " + coach.getTeam());
		// Close the context
		context.close();

	}

}
=======
package com.kartik;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// Read Spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);
		// Get the bean
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		// Methods of Bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println("Email : " + coach.getEmail());
		System.out.println("Team : " + coach.getTeam());
		// Close the context
		context.close();

	}

}
>>>>>>> ee61d503e6b3e08da756937c30fc01d282638335
