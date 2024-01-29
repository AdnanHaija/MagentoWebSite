package MyTestCases;

import java.util.Random;

public class Parameters {

	Random rand = new Random();

	String[] FirstNames = { "Emma", "Liam", "Olivia", "Noah", "Ava", "William", "Sophia", "James", "Isabella",
			"Benjamin" };
	String[] LastNames = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore",
			"Taylor" };
	String CommonPassword = "Adnan@123";

	int RandomIndex = rand.nextInt(10);
	int RandomEmailId = rand.nextInt(9999);
	String EmailId = FirstNames[RandomIndex]+LastNames[RandomIndex]+RandomEmailId+"@"+"gmail.com";
	

}
