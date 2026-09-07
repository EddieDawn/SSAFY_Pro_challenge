import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int idx = 1000;
        int[] arr = new int[2001];
        Arrays.fill(arr, 0);
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            int dirPM = dir.equals("R") ? 1 : -1;
//            System.out.println(dirPM);
            for (int j = 0; j < num; j++) {
                if (dirPM > 0) {
                    arr[idx]++;
                    idx++;
                } else {
                    arr[idx - 1]++;
                    idx--;
                }
//                System.out.println(Arrays.toString(arr) + " idx: " + idx);
            }

        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 2)
                ans++;
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
