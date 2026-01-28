import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
class LanguageDatabase {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> nameArray = new ArrayList<>(),
		familyArray = new ArrayList<>(),
		countryArray = new ArrayList<>(),
		speakersArray = new ArrayList<>(),
		linkArray = new ArrayList<>();
	static File file = new File("Language Database Commands.txt");
	static int ln = 16, lf = 16, lc = 16;
	static int not(int i, int j) {
		return ((j / 8) - (i / 8)) + 1;
	}

	static void add(String[] array) {
		for (int i = 1; i < array.length; i++) {
			array[i] = array[i].replace(",", "");
		}
		for (int j = 2; j < array.length; j++) {
			array[j] = array[j].replace("_", " ").replace(",", "");
		}
		if (array[1].length() > ln) ln = array[1].length();
		if (array[2].length() > lf) lf = array[2].length();
		if (array[3].length() > lc) lc = array[3].length();
		nameArray.add(array[1]);
		familyArray.add(array[2]);
		countryArray.add(array[3]);
		speakersArray.add(array[4]);
	}

	static void view(String key) {
		if (key.matches("\\d+")) {
			int keyInt = Integer.parseInt(key);
			if (nameArray.size() <= keyInt) {
				System.out.println("Invalid number. Please try again.");
			} else {
				System.out.printf("%nDatabase Number: %d%nLanguage Name: %s%nLanguage Family: %s%nCountry of Origin: %s%nNumber of Speakers: %s%n%n", keyInt, nameArray.get(keyInt).replace("_", " "), familyArray.get(keyInt), countryArray.get(keyInt), speakersArray.get(keyInt));
			}
		} else {
			boolean found = false;
			for (int i = 0; i < nameArray.size(); i++) {
				if (nameArray.get(i).toUpperCase().equals(key.toUpperCase())) {
					System.out.printf("%nDatabase Number: %d%nLanguage Name: %s%nLanguage Family: %s%nCountry of Origin: %s%nNumber of Speakers: %s%n%n", i, nameArray.get(i).replace("_", " "), familyArray.get(i), countryArray.get(i), speakersArray.get(i));
					found = true;
				}
			}
			if (!found) {
				System.out.println("Language not found in database.");
			}
		}
	}

	static void viewAll() {
		System.out.println();
		for (int i = 0; i < nameArray.size(); i++) {
			if (i == 0) {
				System.out.print("\t");
			} else {
				System.out.print(i + "\t");
			}
			System.out.print(nameArray.get(i).replace("_", " "));
			for (int j = 1; j <= not(nameArray.get(i).length(), ln); j++) {
				System.out.print("\t");
			}
			System.out.print(familyArray.get(i));
			for (int k = 1; k <= not(familyArray.get(i).length(), lf); k++) {
				System.out.print("\t");
			}
			System.out.print(countryArray.get(i));
			for (int l = 1; l <= not(countryArray.get(i).length(), lc); l++) {
				System.out.print("\t");
			}
			System.out.println(speakersArray.get(i));
		}
		System.out.println();
	}

	static void delete(String key) {
		if (key.matches("\\d+")) {
			int keyInt = Integer.parseInt(key);
			if (nameArray.size() <= keyInt) {
				System.out.println("Invalid number. Please try again.");
			} else {
				nameArray.remove(keyInt);
				familyArray.remove(keyInt);
				countryArray.remove(keyInt);
				speakersArray.remove(keyInt);
			}
		} else {
			boolean found = false;
			for (int i = 0; i < nameArray.size(); i++) {
				if (nameArray.get(i).toUpperCase().equals(key.toUpperCase())) {
					nameArray.remove(i);
					familyArray.remove(i);
					countryArray.remove(i);
					speakersArray.remove(i);
					found = true;
				}
			}
			if (!found) {
				System.out.println("Language not found in database.");
			}
		}
	}

	static void scannerLoop() {
		System.out.println("          ======================");
		System.out.println("          | Welcome   to   the |");
		System.out.println("          | LANGUAGE  DATABASE |");
		System.out.println("          ======================");
		System.out.println();
		System.out.println("Please read the complimentary text file...");
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().open(file);
			} catch (IOException e) {
				System.out.println("Error opening file: " + e);
			}
		}
		System.out.println();
		while (true) {
			System.out.print("> ");
			String input = scanner.nextLine();
			String[] temporaryArray = input.split(" ");
			switch (temporaryArray[0].toUpperCase()) {
			case "ADD":
				if (temporaryArray.length != 5) {
					System.out.println("Invalid arguments. Please try again.");
				} else {
					add(temporaryArray);
				}
				break;
			case "VIEW":
				if (temporaryArray.length != 2) {
					System.out.println("Invalid arguments. Please try again.");
				} else {
					view(temporaryArray[1]);
				}
				break;
			case "SHOW":
				if (temporaryArray.length < 2) {
					System.out.println("Invalid arguments. Please try again.");
				}
				if (temporaryArray[1].toUpperCase().equals("ALL")) {
					viewAll();
				} else {
					for (int i = 1; i < temporaryArray.length; i++) {
						view(temporaryArray[i]);
					}
				}
				break;
			case "DELETE":
				if (temporaryArray.length != 2) {
					System.out.println("Invalid arguments. Please try again.");
				} else {
					delete(temporaryArray[1]);
				}
				break;
			case "CLEAR":
				System.out.print("Are you sure? (Y/N) ");
				char clear = scanner.nextLine().toUpperCase().charAt(0);
				if (clear == 'Y') {
					nameArray.clear();
					familyArray.clear();
					countryArray.clear();
					speakersArray.clear();
				}
				break;
			case "QUIT":
				System.out.print("Are you sure? (Y/N) ");
				char quit = scanner.nextLine().toUpperCase().charAt(0);
				if (quit == 'Y') {
					System.exit(0);
				}
			}
		}
	}

	public static void main(String[] args) {
		nameArray.add("LANGUAGE NAME");
		familyArray.add("LANGUAGE FAMILY");
		countryArray.add("COUNTRY OF ORIGIN");
		speakersArray.add("NUMBER OF SPEAKERS");
		scannerLoop();
	}
}
