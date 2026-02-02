import java.util.Scanner;

public class NumberOfSyllables {
	static Scanner jake = new Scanner(System.in);
	static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

	static String input(String message) {
		System.out.print(message);
		return jake.nextLine();
	}

	/// only works for Tagalog words
	public static void main(String[] Jake) {
		String word = input("Enter a Tagalog word: ");
		int syllables = 0;
		for (char character : word.toCharArray()) {
			for (char vowel : vowels) {
				if (character == vowel) {
					syllables++;
				}
			}
		}
		System.out.println("The word \"" + word + "\" has " + syllables + " syllables.");
	}
}
