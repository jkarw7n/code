import java.util.Scanner;

class DecimalToBinary {
    static String toBinary(int integer) {
        String output = "";
        while (integer > 0) {
            output = integer % 2 + output;
            integer /= 2;
        }
        return output;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int integer = scanner.nextInt();
        scanner.close();
        System.out.println(integer + " in binary would be " + toBinary(integer) + ".");
    }
}
