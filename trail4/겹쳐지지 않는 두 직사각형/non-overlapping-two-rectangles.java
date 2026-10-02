import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int[][] preSum;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        preSum = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                preSum[i][j] = grid[i][j];
                
                if (i > 0) {
                    preSum[i][j] += preSum[i - 1][j];
                }
                if (j > 0) {
                    preSum[i][j] += preSum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    preSum[i][j] -= preSum[i - 1][j - 1];
                }
                
//                System.out.print(preSum[i][j] + " ");
            }
//            System.out.println();
        }
        
        int[] top = new int[n]; // 0행부터 특정 행까지 만드는 사각형 중 넓이 최댁값 모음
        int[] bottom = new int[n];// 특정 행부터 n-1행까지 만드는 사각형 중 넓이 최댁값 모음
        int[] right = new int[m]; //0열부터 특정 어쩌구
        int[] left = new int[m]; // 특정 열부터 m-1 열 저쩌구
        
        Arrays.fill(top, Integer.MIN_VALUE);
        Arrays.fill(bottom, Integer.MIN_VALUE);
        Arrays.fill(left, Integer.MIN_VALUE);
        Arrays.fill(right, Integer.MIN_VALUE);
        
        for (int iS = 0 ; iS < n ; iS++) {
            for (int jS = 0 ; jS < m ; jS++) {
                for (int iE = iS ; iE < n ; iE++) {
                    for (int jE = jS ; jE < m ; jE++) {
                        int sum = calcSum(iS, jS, iE, jE);
                        top[iE] = Math.max(top[iE], sum);
                        bottom[iS] = Math.max(bottom[iS], sum);
                        left[jE] = Math.max(left[jE], sum);
                        right[jS] = Math.max(right[jS], sum);
                    }
                }
            }
        }
        
        for (int r = 1; r < n; r++) {
            top[r] = Math.max(top[r], top[r - 1]);
        }

        for (int r = n - 2; r >= 0; r--) {
            bottom[r] = Math.max(bottom[r], bottom[r + 1]);
        }

        for (int c = 1; c < m; c++) {
            left[c] = Math.max(left[c], left[c - 1]);
        }

        for (int c = m - 2; c >= 0; c--) {
            right[c] = Math.max(right[c], right[c + 1]);
        }

        int ans = Integer.MIN_VALUE;
        for (int row = 0 ; row < n - 1 ; row++) {
            ans = Math.max(ans, top[row] + bottom[row + 1]);
        }
        for (int col = 0 ; col < m - 1 ; col++) {
            ans = Math.max(ans, left[col] + right[col + 1]);
        }
        
        System.out.println(ans);
    }

    static int calcSum(int iS, int jS, int iE, int jE) {
        int tmp = preSum[iE][jE];         

        if (iS > 0) {
            tmp -= preSum[iS - 1][jE];   
        }

        if (jS > 0) {
            tmp -= preSum[iE][jS - 1];  
        }

        if (iS > 0 && jS > 0) {
            tmp += preSum[iS - 1][jS - 1];
        }

        return tmp;
    }
}