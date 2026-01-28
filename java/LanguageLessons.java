abstract class Lesson {
    abstract void startLesson();
    abstract void endLesson();
}

class VocabularyLesson extends Lesson {
    protected boolean inProgress;
    
    public VocabularyLesson() {
        inProgress = false;
    }
    
    @Override
    public void startLesson() {
        inProgress = true;
        System.out.println("Vocabulary lesson has started.");
    }
    
    @Override
    public void endLesson() {
        inProgress = false;
        System.out.println("Vocabulary lesson has ended.");
    }
    
    public boolean isInProgress() { return inProgress; }
}

class Language {
    private String name, originCountry, difficultyLevel;
    
    public Language(String name, String country, String level) {
        this.name = name;
        originCountry = country;
        difficultyLevel = level;
    }
    
    public String getName() { return name; }
    public String getCountry() { return originCountry; }
    public String getLevel() { return difficultyLevel; }
}

class User {
    protected String username;
    protected int id, wordsLearned;
    
    public User(String username, int id) {
        this.username = username;
        this.id = id;
        this.wordsLearned = 0;
    }
    
    public void learnWord(String word, VocabularyLesson vl) {
        if (vl.isInProgress()) {
            System.out.println(username + " has learnt " + word + "!");
            wordsLearned++;
        } else {
            System.out.println("Lesson has not yet started.");
        }
    }
    
    public String getUsername() { return username; }
    public int getId() { return id; }
    public int getWords() { return wordsLearned; }
}

class BeginnerUser extends User {
    private int wordsRemaining = 10;
    
    public BeginnerUser(String username, int id) {
        super(username, id);
    }
    
    @Override
    public void learnWord(String word, VocabularyLesson vl) {
        if (wordsRemaining > 0 && vl.isInProgress()) {
            System.out.println(super.username + " has learnt " + word + "!");
            super.wordsLearned++;
            wordsRemaining--;
        } else {
            System.out.println("No available words remaining or lesson has not yet started.");
        }
    }
}

class AdvancedUser extends User {
    public AdvancedUser(String username, int id) {
        super(username, id);
    }
}

public class LanguageLessons {
    public static void main(String[] args) {
        VocabularyLesson vl = new VocabularyLesson();
        vl.startLesson();
        Language l1 = new Language("Kawesqar", "Chile", "Hard");
        BeginnerUser b1 = new BeginnerUser("Charlie", 20298);
        AdvancedUser a1 = new AdvancedUser("Kai", 19091);
        for (int i = 1; i <= 11; i++) {
            b1.learnWord("narra", vl);
        }
        a1.learnWord("kiss", vl);
        System.out.println(b1.getWords() + " and " + a1.getWords() + " words");
        vl.endLesson();
    }
}
