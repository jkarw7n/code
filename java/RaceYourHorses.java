import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

abstract class Race {
    abstract void startRace();
    abstract void endRace();
}

class HorseRace {
    private boolean hasStarted, hasEnded;
    private ArrayList<Horse> list = new ArrayList<>();
    
    public HorseRace() {
        hasStarted = false;
        hasEnded = false;
    }
    
    public void startRace() {
        hasStarted = true;
        System.out.println("The race starts now!");
    }
    
    public void endRace() {
        hasStarted = false;
        hasEnded = true;
        Collections.sort(list, Comparator.comparingDouble(Horse::getSpeed).reversed());
        System.out.println("The race has now ended!\n");
        Horse h = list.get(0);
        System.out.printf("Number %d %s, owned by %s, won the race with a speed of %.2f!%n%n=== FULL RESULTS ===%n", h.getNumber(), h.getName(), h.getOwner(), h.getSpeed());
        getResults();
    }
    
    public boolean hasStarted() { return hasStarted; }
    
    public void addHorse(Horse h) {
        if (!hasStarted) {
            list.add(h);
            System.out.println("Horse " + h.getName() + " has joined the race!");
        } else {
            System.out.println("No can do. The race has already started.");
        }
    }
    
    public Horse getWinningHorse() {
        if (hasEnded) {
            return list.get(0);
        }
        return null;
    }
    
    public void getResults() {
        if (hasEnded) {
            for (int i = 0; i < list.size(); i++) {
                Horse h = list.get(i);
                System.out.printf("%d\t%s (%d) / %s / %.2f%n", i + 1, h.getName(), h.getNumber(), h.getOwner(), h.getSpeed());
            }
        } else {
            System.out.println("The race hasn't ended yet.");
        }
    }
}

class Horse {
    private String name, owner;
    private int number;
    private double speed;
    private Random random = new Random();
    
    public Horse(String name, String owner, int number) {
        this.name = name;
        this.owner = owner;
        this.number = number;
        this.speed = random.nextDouble(25, 40);
    }
    
    public String getName() { return name; }
    public String getOwner() { return owner; }
    public int getNumber() { return number; }
    public double getSpeed() { return speed; }
}

public class RaceYourHorses {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        HorseRace hr = new HorseRace();
        System.out.print("Enter number of horses: ");
        int numberOfHorses = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfHorses; i++) {
            System.out.print("Enter horse name: ");
            String name = scanner.nextLine();
            System.out.print("Enter owner name: ");
            String owner = scanner.nextLine();
            System.out.print("Enter number: ");
            int number = scanner.nextInt();
            scanner.nextLine();
            hr.addHorse(new Horse(name, owner, number));
        }
        hr.startRace();
        hr.addHorse(new Horse("Liam Runt", "Paul Macaulay", 28));
        hr.endRace();
    }
}
