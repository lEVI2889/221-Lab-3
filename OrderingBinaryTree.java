/*import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
public class OrderingBinaryTree {
    public static void main(String[] args) throws IOException {
        BufferedReader task = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer st;
        long len = Long.parseLong(task.readLine());
        st = new StringTokenizer(task.readLine());
        long[] arr = new long[(int) len];
        for (int i = 0; i < len; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        List<Long> result = findMinHeightArray(arr);
        for(Long num : result) output.append(num).append("\n");
        System.out.println(output.toString().trim());
    }
    static List<Long> findMinHeightArray(long[] arr) {
        List<Long> res = new ArrayList<>();
        midArrayFinder(0, arr.length-1, arr, res);
        return res;
    }
    static void midArrayFinder(int start, int end, long[] arr, List<Long> res){
        if(start>end) return;
        int mid = start + (end - start) / 2;
        res.add(arr[mid]);
        midArrayFinder(start, mid-1, arr, res);
        midArrayFinder(mid+1, end, arr, res);
    }
}*/
import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
public class OrderingBinaryTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        List<Long> result = findRes(arr);
        for (Long num : result) {
            output.append(num).append(" ");
        }
        System.out.print(output.toString().trim());
    }
    static List<Long> findRes(long[] arr){
        List<Long> res = new ArrayList<>();
        FindMinHeightArray(0, arr.length-1, arr, res);
        return res;
    }
    static void FindMinHeightArray(int start, int end, long[] arr, List<Long> res){
        if(start>end) return;
        int mid = start + (end - start)/2;
        res.add(arr[mid]);
        FindMinHeightArray(start, mid-1, arr, res);
        FindMinHeightArray(mid+1, end, arr, res);
    }
}

