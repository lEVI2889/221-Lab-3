//AI Written
import java.io.*;
import java.util.*;

public class InversionCount {
    static long inversionCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader task = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(task.readLine().trim());
        int[] arr = Arrays.stream(task.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        mergeSort(arr, 0, n - 1);

        System.out.println(inversionCount);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // All elements from i to mid are greater than arr[j]
                inversionCount += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
