import java.util.Scanner;

public class Main {
    static int numSeg = 0;
    static boolean[] master = new boolean[1002];
    static int n;
    static int[][] segments;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        // Please write your code here.
        ans = 0;
        select(0);

        System.out.println(ans);
    }

    static void select(int segIdx) {

        if (segIdx == n) {
            ans = Math.max(ans, numSeg);
            return;
        }

        // sedIdx번째 선분을 선택 안할 때
        select(segIdx + 1);

        // sedIdx번째 선분을 선택할 때
        boolean possible = true;
        for (int start = segments[segIdx][0]; start <= segments[segIdx][1]; start++) {
            if (master[start]) {
                possible = false;
                break;
            }
        }

        if (possible) {
            for (int start = segments[segIdx][0]; start <= segments[segIdx][1]; start++) {
                master[start] = true;
            }
            numSeg++;
            select(segIdx + 1);
            numSeg--;

            for (int start = segments[segIdx][0]; start <= segments[segIdx][1]; start++) {
                master[start] = false;
            }
        }

    }
}