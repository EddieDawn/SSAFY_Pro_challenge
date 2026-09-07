import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] arr = new int[201];
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start + 100; j < end + 100; j++) {
                arr[j]++;
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (ans < arr[i])
                ans = arr[i];
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
