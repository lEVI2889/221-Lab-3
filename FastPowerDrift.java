import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class FastPowerDrift {
    static final int MOD = 107;
    public static void main(String[] args) throws IOException {
        BufferedReader task = new BufferedReader(new InputStreamReader(System.in));
        long [] inputs = Arrays.stream(task.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
        long base = inputs[0];
        long power = inputs[1];
        System.out.println(ExponentialMethod(base, power));
    }
    static long ExponentialMethod(long base, long power) {
        long res = 1;
        base %= MOD;
        while (power > 0){
            if((power & 1) == 1){
                res = (res*base)%MOD;
            }
            base = (base*base)%MOD;
            power >>= 1;
        }
        return res;
    }
}
/*import java.io.*;
import java.util.*;

public class FastMatrixDrift {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        // Use more efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        long t = Long.parseLong(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            // Use StringTokenizer for faster parsing
            st = new StringTokenizer(br.readLine());
            long[][] matrix = new long[2][2];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    matrix[i][j] = Long.parseLong(st.nextToken());
                }
            }

            long power = Long.parseLong(br.readLine());
            long[][] result = matrixPower(matrix, power);

            // Direct output writing
            out.println(result[0][0] + " " + result[0][1]);
            out.println(result[1][0] + " " + result[1][1]);
        }

        out.flush();
    }

    // Simplified matrix multiplication with direct modulo
    static long[][] matrixMultiply(long[][] a, long[][] b) {
        long[][] res = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }

    // More efficient matrix exponentiation
    static long[][] matrixPower(long[][] base, long power) {
        long[][] result = {{1, 0}, {0, 1}};

        while (power > 0) {
            if ((power & 1) == 1) {
                result = matrixMultiply(result, base);
            }
            base = matrixMultiply(base, base);
            power >>= 1;
        }

        return result;
    }
}
*/