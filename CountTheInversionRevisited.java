import java.util.*;

public class CountTheInversion {
    static class BIT {
        int[] tree;
        int size;
        BIT(int n) {
            size = n;
            tree = new int[n + 2]; // 1-based indexing
        }
        void update(int i, int delta) {
            while (i <= size) {
                tree[i] += delta;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }

        int queryRange(int left, int right) {
            return query(right) - query(left - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        TreeSet<Long> values = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
            values.add(nums[i]);
            values.add(nums[i] * nums[i]);  // Also include squares
        }

        // Coordinate compression
        Map<Long, Integer> indexMap = new HashMap<>();
        int idx = 1;
        for (long v : values) {
            indexMap.put(v, idx++);
        }

        BIT bit = new BIT(indexMap.size());
        long count = 0;

        for (long val : nums) {
            long sq = val * val;
            int sqIdx = indexMap.get(sq);
            int totalInserted = bit.query(bit.size);
            int greaterThanSq = totalInserted - bit.query(sqIdx);
            count += greaterThanSq;

            int valIdx = indexMap.get(val);
            bit.update(valIdx, 1);  // Insert this value
        }

        System.out.println(count);
    }
}
