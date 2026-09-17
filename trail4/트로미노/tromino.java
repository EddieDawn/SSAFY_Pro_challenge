import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int ans;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 1; k <= 6; k++) {
                    check(i, j, k);
                }
            }
        }
        System.out.println(ans);
    }

    static void check(int i, int j, int k) {
        int i2, j2, i3, j3 = 0;
        switch (k) {
        case 1:
            i2 = i;
            j2 = j + 1;
            i3 = i + 1;
            j3 = j;
            break;
        case 2:
            i2 = i;
            j2 = j - 1;
            i3 = i + 1;
            j3 = j;
            break;
        case 3:
            i2 = i - 1;
            j2 = j;
            i3 = i;
            j3 = j + 1;
            break;
        case 4:
            i2 = i - 1;
            j2 = j;
            i3 = i;
            j3 = j - 1;
            break;
        case 5:
            i2 = i;
            j2 = j + 1;
            i3 = i;
            j3 = j + 2;
            break;
        case 6:
            i2 = i + 1;
            j2 = j;
            i3 = i + 2;
            j3 = j;
            break;
        default:
            i2 = -1;
            j2 = -1;
            i3 = -1;
            j3 = -1;
        }

        if (!(i2 >= 0 && i2 < n && j2 >= 0 && j2 < m && i3 >= 0 && i3 < n && j3 >= 0 && j3 < m)) {
            return;
        }

        int tmpAns = grid[i][j] + grid[i2][j2] + grid[i3][j3];
        ans = Math.max(tmpAns, ans);
    }
}