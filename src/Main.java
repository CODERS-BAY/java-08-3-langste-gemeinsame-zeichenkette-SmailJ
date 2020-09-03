import java.util.*;

public class Main {

    static void printChain(String first, String secound, int firstInt, int secoundInt) {

        int equal[][] = new int[firstInt + 1][secoundInt + 1];

        int length = 0, column = 0, row = 0;

        for (int i = 0; i <= firstInt; i++) {
            for (int j = 0; j <= secoundInt; j++) {
                if (i == 0 || j == 0)
                    equal[i][j] = 0;

                else if (first.charAt(i - 1) == secound.charAt(j - 1)) {
                    equal[i][j] = equal[i - 1][j - 1] + 1;
                    if (length < equal[i][j]) {
                        length = equal[i][j];
                        row = i;
                        column = j;
                    }
                } else
                    equal[i][j] = 0;
            }
        }

        if (length == 0) {
            System.out.println("No Common Substring");
            return;
        }


        String resultStr = "";


        while (equal[row][column] != 0) {
            resultStr = first.charAt(row - 1) + resultStr;
            --length;
            row--;
            column--;
        }

        System.out.println(resultStr);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Erste Kette:");
        String first = sc.next();
        System.out.println("Zweite Kette:");
        String secound = sc.next();

        int firstInt = first.length();
        int secoundInt = secound.length();


        printChain(first, secound, firstInt, secoundInt);
    }

}
