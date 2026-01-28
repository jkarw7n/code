import java.util.Scanner;
import java.util.ArrayList;
class TableOfLanguages {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> languageArray = new ArrayList<>(), familyArray = new ArrayList<>(), countryArray = new ArrayList<>();
    static int lll = 0, lfl = 0;
    static int numberOfTabs(int longest, String string) {
        return ((longest / 4) - (string.length() / 4)) + 1;
    }
    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter QUIT to quit...\nEnter language name: ");
            String language = scanner.nextLine();
            if (language.toUpperCase().equals("QUIT")) {
                break;
            }
            if (language.length() > lll) {
                lll = language.length();
            }
            languageArray.add(language);
            System.out.print("Enter language family: ");
            String family = scanner.nextLine();
            if (family.length() > lfl) {
                lfl = family.length();
            }
            familyArray.add(family);
            System.out.print("Enter country of origin: ");
            String country = scanner.nextLine();
            countryArray.add(country);
        }
        System.out.println();
        String output = "";
        for (int i = 0; i < languageArray.size(); i++) {
            output += languageArray.get(i);
            for (int j = 1; j <= numberOfTabs(lll, languageArray.get(i)); j++) {
                output += "\t";
            }
            output += familyArray.get(i);
            for (int k = 1; k <= numberOfTabs(lfl, familyArray.get(i)); k++) {
                output += "\t";
            }
            output += countryArray.get(i) + "\n";
        }
        System.out.println(output);
    }
}
