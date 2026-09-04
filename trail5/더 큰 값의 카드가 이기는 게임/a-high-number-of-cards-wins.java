import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bCards = new int[n];
        for (int i = 0; i < n; i++) {
        bCards[i] = sc.nextInt();
        }
        // Please write your code here.
        boolean[] deck = new boolean[2 * n+1];
        for (int i = 0 ; i < 2 * n+1 ; i++) deck[i] = false;
        for (int i = 0 ; i < n ; i++) {
            deck[bCards[i]] = true;
        }
        int store = 0;
        int win = 0;
        for (int i = 0 ; i < 2 * n + 1 ; i++) {
            if (deck[i] == false && store != 0) {
                store--;
                win++;
            }
            if (deck[i] == true) store++;
        }
        System.out.println(win);
    }
}