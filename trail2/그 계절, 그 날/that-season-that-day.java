import java.util.Scanner;

public class Main {

    public static boolean isLeapYear(int y) {
        if (y % 400 == 0) {
            return true;
        }

        if (y % 100 == 0) {
            return false;
        }

        if (y % 4 == 0) {
            return true;
        }

        return false;
    }

    public static boolean isValidDate(int y, int m, int d) {

        if (m < 1 || m > 12) {
            return false;
        }

        int[] days = {
            0,
            31, 28, 31, 30,
            31, 30, 31, 31,
            30, 31, 30, 31
        };

        if (isLeapYear(y)) {
            days[2] = 29;
        }

        if (d < 1 || d > days[m]) {
            return false;
        }

        return true;
    }

    public static String getSeason(int m) {

        if (m >= 3 && m <= 5) {
            return "Spring";
        } else if (m >= 6 && m <= 8) {
            return "Summer";
        } else if (m >= 9 && m <= 11) {
            return "Fall";
        } else {
            return "Winter";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        if (!isValidDate(y, m, d)) {
            System.out.println(-1);
            return;
        }

        System.out.println(getSeason(m));
    }
}