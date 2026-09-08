import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static class Tile {
        boolean isBlack = false;

        public Tile() {
            this.isBlack = false;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Tile[] arr = new Tile[200001];
        int idx = 100000;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            if (dir == 'R') {
                for (int j = 0; j < num; j++) {
                    if (arr[idx] == null)
                        arr[idx] = new Tile();
                    arr[idx].isBlack = true;
                    idx++;
                }
                idx--;
            } // 오른쪽으로 이동하며 검정칠
            else {
                for (int j = 0; j < num; j++) {
                    if (arr[idx] == null)
                        arr[idx] = new Tile();
                    arr[idx].isBlack = false;
                    idx--;
                }
                idx++;
            } // 왼쪽으로 이동하며 하양칠
        }

//        for (Tile tile : arr) {
//            if (tile != null) {
//                System.out.println("tile.numWhile: " + tile.numWhite + " tile.numBlack: " + tile.numBlack + " black: "
//                        + tile.isBlack + " grey: " + tile.isGrey);
//            }
//        }

        int numBlackTile = 0;
        int numWhiteTile = 0;

        for (Tile tile : arr) {
            if (tile != null) {
                if (tile.isBlack)
                    numBlackTile++;
                else
                    numWhiteTile++;
            }
        }

        bw.write(numWhiteTile + " " + numBlackTile + " " + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
