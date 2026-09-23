import java.io.*;
import java.util.*;

public class Main {
    // Return the minimum sum of any contiguous window of size k
    static int solve(int[] power, int k) {
        // Write your code here
        int currsum=0;
        for(int i=0;i<k;i++){
            currsum+=power[i];
        }
        int min=currsum;
        for(int i=k;i<power.length;i++){
            currsum=currsum-power[i-k]+power[i];
            min=Math.min(currsum,min);
        }
        return min;
    }

    // ---- Do not edit below: input parsing and output ----
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        String nToken = fr.next();
        if (nToken == null) return;
        int n = Integer.parseInt(nToken);
        int k = fr.nextInt();
        int[] power = new int[n];
        for (int i = 0; i < n; i++) power[i] = fr.nextInt();
        System.out.println(solve(power, k));
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }
    }
}
