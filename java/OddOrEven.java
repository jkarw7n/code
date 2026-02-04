import java.util.Scanner;
import java.util.Arrays;

public class OddOrEven {
	static Scanner jake = new Scanner(System.in);
	static int even = 0, odd = 0;
	static String integerString = "";

	static void OddOrEven(int integer) {
		String oddOrEven;
		if (integer % 2 == 0) {
			oddOrEven = "even";
			even++;
		} else {
			oddOrEven = "odd";
			odd++;
		}
		System.out.println(integer + " is an " + oddOrEven + " number.");
	}

	static void OddOrEven() {
		do {
			System.out.print("Please enter an integer (0 to QUIT): ");
			int integer = jake.nextInt();
			if (integer == 0) {
				System.out.println("Terminating program...\n");
				break;
			} else {
				OddOrEven(integer);
			}
			integerString += integer + " ";
		} while (true);
	}

	static void PrintStatistics() {
		String[] stringArray = integerString.split(" ");
		int[] integerArray = new int[stringArray.length];
		for (int i = 0; i < integerArray.length; i++) {
			integerArray[i] = Integer.parseInt(stringArray[i]);
		}
		String arrayString = Arrays.toString(integerArray);
		System.out.println("===== STATISTICS =====");
		System.out.println("Values: " + arrayString);
		System.out.println("Number of values: " + integerArray.length);
		Arrays.sort(integerArray);
		arrayString = Arrays.toString(integerArray);
		System.out.println("Sorted values: " + arrayString);
		System.out.println("Lowest value: " + integerArray[0]);
		System.out.println("Highest value: " + integerArray[integerArray.length - 1]);
		System.out.println("Range of values: " + (integerArray[integerArray.length - 1] - integerArray[0]));
		System.out.println("Number of even numbers: " + even);
		System.out.println("Number of odd numbers: " + odd);
	}

	public static void main(String[] Jake) {
		OddOrEven();
		jake.close();
		PrintStatistics();
	}
}
