<<<<<<< HEAD
package com.kartik;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// Load the config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve bean from the spring container
		Coach coach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		// Call the beans
		boolean check = coach == alphaCoach;

		System.out.println("Same reference : " + check);
		System.out.println("Memory Location for Coach : " + coach);
		System.out.println("Memory Location for Alpha Coach : " + alphaCoach);

		// Close the bean
		context.close();
	}

}
=======
package com.kartik;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// Load the config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve bean from the spring container
		Coach coach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		// Call the beans
		boolean check = coach == alphaCoach;

		System.out.println("Same reference : " + check);
		System.out.println("Memory Location for Coach : " + coach);
		System.out.println("Memory Location for Alpha Coach : " + alphaCoach);

		// Close the bean
		context.close();
	}

}
>>>>>>> ee61d503e6b3e08da756937c30fc01d282638335
