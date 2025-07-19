
/*import java.io.*;
import java.util.*;

public class CountTheInversion {
    static class FenwickTree {
        long[] bit;
        int size;

        FenwickTree(int size) {
            this.size = size;
            bit = new long[size + 2];
        }

        void update(int index, int val) {
            while (index <= size) {
                bit[index] += val;
                index += index & -index;
            }
        }

        long query(int index) {
            long sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }

        long rangeQuery(int l, int r) {
            return query(r) - query(l - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        TreeSet<Long> set = new TreeSet<>();

        // Read array and collect values for compression
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
            set.add(A[i]);
            set.add(A[i] * A[i]);  // Add square too
        }

        // Coordinate compression
        Map<Long, Integer> compress = new HashMap<>();
        int idx = 1;
        for (long val : set) {
            compress.put(val, idx++);
        }

        // BIT of compressed size
        FenwickTree bit = new FenwickTree(compress.size() + 2);
        long count = 0;

        for (int i = 0; i < N; i++) {
            long square = A[i] * A[i];
            int sqIndex = compress.get(square);
            // Count how many values inserted so far > square
            count += bit.rangeQuery(sqIndex + 1, bit.size);
            // Insert current A[i]
            bit.update(compress.get(A[i]), 1);
        }

        System.out.println(count);
    }
}*/
import java.util.*;
import java.io.*;
public class CountTheInversion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        TreeSet<Long> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            set.add(arr[i]);
            set.add(arr[i]*arr[i]);
        }
        Map<Long, Integer> compress = new HashMap<>();
        int idx = 1;
        for(long i : set) compress.put(i, idx++);
        FenwickTree bit = new FenwickTree(compress.size()+2);
        long count = 0;
        for (int i = 0; i < n; i++) {
            long square = arr[i]*arr[i];
            int sqIdx = compress.get(square);
            count += bit.rangeQuery(sqIdx+1, bit.size);
            bit.update(compress.get(arr[i]), 1);
        }
        System.out.println(count);
    }
    public static class FenwickTree {
        long[] bit;
        int size;
        FenwickTree(int size) {
            this.size = size;
            bit = new long[size+2];
        }
        void update(int idx, int value){
            while(idx<=size){
                bit[idx]+=value;
                idx +=idx & -idx;
            }
        }
        long query(int idx){
            long sum = 0;
            while(idx>0){
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
        long rangeQuery(int l, int r){
            return query(r)-query(l-1);
        }
    }
}
