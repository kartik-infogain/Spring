<<<<<<< HEAD
package com.kartik;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] data = {
			"Beware of Monkeys",
			"Make your peers happy",
			"Be hard working"
	};
	
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		return data[index];
	}

}
=======
package com.kartik;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] data = {
			"Beware of Monkeys",
			"Make your peers happy",
			"Be hard working"
	};
	
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		return data[index];
	}

}
>>>>>>> ee61d503e6b3e08da756937c30fc01d282638335
