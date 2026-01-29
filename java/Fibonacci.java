import java.util.Scanner;
class Fibonacci {
    static void fibonacci(int integer) {
        int a = 1, b = 0;
        for (int i = 1; i <= integer; i++) {
            System.out.print(a + " ");
            int c = a;
            a += b;
            b = c;
            // 1,0 = 1; 1,1 = 2; 
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int integer = scanner.nextInt();
        scanner.close();
        fibonacci(integer);
    }
}
