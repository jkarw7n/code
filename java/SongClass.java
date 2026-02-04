import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Song {
    private String title, artist, minutesAndSeconds;
    private int seconds;
    
    private void translateSeconds() {
        String zero = String.valueOf(seconds % 60).length() == 1 ? "0" : "";
        minutesAndSeconds = String.valueOf((int) seconds / 60) + ":" + zero + String.valueOf(seconds % 60);
    }
    
    /// default initializer
    Song(String title, String artist, int seconds) {
        this.title = title;
        this.artist = artist;
        this.seconds = seconds;
        translateSeconds();
    }
    
    /// also adds object to list
    Song(String title, String artist, int seconds, List<Song> list) {
        this(title, artist, seconds);
        list.add(this);
    }
    
    void display(String delimiter) {
        delimiter = delimiter == null ? "" : delimiter;
        System.out.print("\"" + title + "\" by " + artist + " (" + minutesAndSeconds + ")" + delimiter);
    }
    
    String getTitle() { return title; }
    String getArtist() { return artist; }
    int getSeconds() { return seconds; }
    String displayString() { return "\"" + title + "\" by " + artist + " (" + minutesAndSeconds + ")"; }
}

public class SongClass {
    static Scanner jake = new Scanner(System.in);
    static List<Song> songs = new ArrayList<>();
    
    static String input(String message) {
        System.out.print(message);
        return jake.nextLine();
    }
    
    public static void main(String[] Jake) {
        while (true) {
            String title = input("Enter song title: "), artist = input("Enter artist name: ");
            int seconds = Integer.parseInt(input("Enter song duration in seconds: "));
            Song newSong = new Song(title, artist, seconds, songs);
            System.out.println("Added " + newSong.displayString() + " to the list.");
            char decision = input("Add another song? (Y/N): ").toUpperCase().charAt(0);
            if (decision == 'N') {
                break;
            }
        }
        System.out.println();
        for (Song song : songs) {
            song.display("\n");
        }
    }
}
