import java.util.Arrays;

class Language {
	private String name, family, country;
	private int speakers;

	Language(String name, String family, String country, int speakers) {
		this.name = name;
		this.family = family;
		this.country = country;
		this.speakers = speakers;
	}

	String getName() { return name; }
	String getFamily() { return family; }
	String getCountry() { return country; }
	int getSpeakers() { return speakers; }

	String[] getArray() { return new String[] {name, family, country, String.valueOf(speakers)}; }
	String getArrayString() { return Arrays.toString(getArray()); }

	void change(String variable, String newValue) {
		switch (variable) {
		case "name": name = newValue; break;
		case "family": family = newValue; break;
		case "country": country = newValue; break;
		default: System.out.println("Invalid first argument. Please try again.");
		}
	}

	/// method overloading
	void change(String variable, int newValue) {
		if (variable.equals("speakers")) {
			speakers = newValue;
		} else {
			System.out.println("Invalid first argument. Please try again.");
		}
	}
}

public class Test {
	public static void main(String[] args) {
		Language language = new Language("Kawesqar", "Alacalufan", "Chile", 10);
		System.out.println(language.getArrayString());
		language.change("speakers", 0);
		System.out.println(language.getArrayString());
	}
}
