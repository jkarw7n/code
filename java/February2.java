import java.util.Scanner;
public class February2 {
    static Scanner jake = new Scanner(System.in);

    static void positiveMaker() {
        System.out.print("Enter an integer: ");
        int integer = jake.nextInt();
        if (integer > 0) System.out.println("The number is positive.");
        else System.out.println("The number is not positive.");
    }

    static void positiveNegativeZero() {
        System.out.print("How many numbers will you input? ");
        int numbers = jake.nextInt(), array[] = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            array[i] = jake.nextInt();
        }
        int positives = 0, negatives = 0, zeros = 0;
        for (int number : array) {
            if (number > 0) positives++;
            else if (number < 0) negatives++;
            else zeros++;
        }
        System.out.printf("Positives: %d%nNegatives: %d%nZeros: %d%n", positives, negatives, zeros);
    }

    static void gradeAnalyzer() {
        System.out.print("Enter number of grades: ");
        int grades[] = new int[jake.nextInt()], sum = 0, highest = 0, lowest = 100; // highest is lowest value by default, lowest the highest
        for (int i = 0; i < grades.length; i++) {
            System.out.print("Grade No. " + (i + 1) + ": ");
            grades[i] = jake.nextInt();
        }
        for (int grade : grades) {
            sum += grade;
            if (grade > highest) highest = grade;
            else if (grade < lowest) lowest = grade;
        }
        System.out.printf("%nAverage Grade: %.2f%nHighest Grade: %d%nLowest Grade: %d%nRange of Grades: %d%n", (double) sum / grades.length, highest, lowest, highest - lowest);
    }

    static void salesReport() {
        int sales[][] = {{1200, 1500, 1700}, {1000, 1100, 1300}, {900, 1200, 1600}}, total = 0;
        for (int i = 0; i < sales.length; i++) {
            System.out.print("Sales for Store " + (i + 1) + ":\t");
            int storeTotal = 0;
            for (int j = 0; j < sales[i].length; j++) {
                storeTotal = sales[i][j];
                total += sales[i][j];
                System.out.print(sales[i][j] + "\t");
            }
            System.out.println("\nTotal sales for Store " + (i + 1) + ": " + storeTotal + "\n");
        }
        System.out.println("Total sales for all stores: " + total);
    }

    static void interactiveSalesReport() {
        System.out.print("Enter number of stores (rows): ");
        int rows = jake.nextInt();
        System.out.print("Enter number of values per store (columns): ");
        int cols = jake.nextInt(), matrix[][] = new int[rows][cols], sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Value " + (j+1) + " for Store " + (i+1) + ": ");
                matrix[i][j] = jake.nextInt();
            }
        }
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("Values for Store " + (i+1) + ": ");
            int storeTotal = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                total += matrix[i][j];
                storeTotal += matrix[i][j];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\t/ Total sales for Store " + (i+1) + ": " + storeTotal);
        }
        System.out.println("Total sales for all stores: " + total);
    }

    public static void main(String[] Jake) {
//        positiveMaker();
//        positiveNegativeZero();
//        gradeAnalyzer();
        interactiveSalesReport();
    }
}
