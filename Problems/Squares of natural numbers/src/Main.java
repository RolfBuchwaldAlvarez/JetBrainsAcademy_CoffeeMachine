import java.util.Scanner;
import static java.lang.Math.sqrt;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int squareNum;

        for (int i = 1; i <= sqrt(num); i++) {
            squareNum = i * i;
            System.out.println(squareNum);
        }
    }
}