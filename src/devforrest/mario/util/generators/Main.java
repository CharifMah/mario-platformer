package devforrest.mario.util.generators;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random randomNumbers = new Random();
	    String lSeedStr = (args.length > 0) ? args[0] : String.valueOf(randomNumbers.nextLong());
	    new SimpleTestGenerator();
	}

}
