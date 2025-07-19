/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountTheInversionRevisited {
    static long inversionCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Create a copy of the original array for sorting
        int[] sortedArr = Arrays.copyOf(arr, n);

        mergeSort(sortedArr, 0, n-1, arr);

        System.out.println(inversionCount);

        // Print the sorted array
        StringBuilder output = new StringBuilder();
        for(int num : sortedArr) {
            output.append(num).append(" ");
        }
        System.out.print(output.toString().trim());
    }

    // Modified merge sort to count inversions with condition A[i] > A[j]²
    static void mergeSort(int[] arr, int left, int right, int[] originalArr) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, originalArr);
            mergeSort(arr, mid+1, right, originalArr);
            merge(arr, left, mid, right, originalArr);
        }
    }

    static void merge(int[] arr, int left, int mid, int right, int[] originalArr) {
        int[] temp = new int[right-left+1];
        int i = left, j = mid+1, k = 0;

        // For each element in the left subarray, count the number of elements
        // in the right subarray where A[i] > A[j]²
        for(int l = left; l <= mid; l++) {
            while(j <= right && (long)arr[l] <= (long)arr[j] * arr[j]) {
                j++;
            }
            inversionCount += (right - j + 1);
            // Reset j for the next element in left subarray
            j = mid + 1;
        }

        // Regular merge process
        i = left;
        j = mid + 1;
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid)
            temp[k++] = arr[i++];

        while(j <= right)
            temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class CountTheInversionRevisited {
    static long inversionCount = 0;
    public static void main(String[] args) throws IOException {
        StringBuilder input = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        mergeSort(arr, 0, n-1);
        System.out.println(inversionCount);
        for(int num:arr){
            input.append(num).append(" ");
        }
        System.out.print(input.toString().trim());
    }
    static void mergeSort(int[] arr, int left, int right) {
        if(left>=right) return;
        int mid = left + (right-left)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }
    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
        int i = left, j = mid+1, k = 0;
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                inversionCount += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid)temp[k++] = arr[i++];
        while(j<=right)temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
