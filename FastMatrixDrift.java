import java.io.*;
import java.util.StringTokenizer;

public class FastMatrixDrift {
    static final long mod = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader task = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(task.readLine());
        while(n-->0) {
            st = new StringTokenizer(task.readLine());
            long[][] matrix = new long[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j <2; j++) {
                    matrix[i][j]= Long.parseLong(st.nextToken());
                }
            }
            long power = Long.parseLong(task.readLine());
            long[][] result = modularExponentiation(matrix, power);
            out.write(result[0][0] + " " + result[0][1]+"\n");
            out.write(result[1][0] + " " + result[1][1]+"\n");
        }
        out.flush();
    }
    static long[][] multiplyMat(long[][] a, long[][] b){
        long[][] res = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % mod;
                }
            }
        }
        return res;
    }
    static long[][] modularExponentiation(long[][] base, long power){
        long [][] res = {{1,0},{0,1}};
        while(power > 0){
            if((power & 1)==1){
                res = multiplyMat(res, base);
            }
            base = multiplyMat(base, base);
            power >>=1;
        }
        return res;
    }
}

