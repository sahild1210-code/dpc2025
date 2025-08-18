import java.util.*;
import java.util.Arrays;

public class MergeSortedArrays {

    // Function to calculate next gap
    private static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2); // ceil(gap/2)
    }

    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int gap = m + n;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            int i, j;

            // Compare elements in arr1
            for (i = 0; i + gap < m; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }

            // Compare elements between arr1 and arr2
            for (j = gap > m ? gap - m : 0; i < m && j < n; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }

            // Compare elements in arr2
            if (j < n) {
                for (j = 0; j + gap < n; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input arr1
        System.out.print("Enter size of arr1: ");
        int m = sc.nextInt();
        int[] arr1 = new int[m];
        System.out.println("Enter " + m + " sorted integers:");
        for (int i = 0; i < m; i++)
            arr1[i] = sc.nextInt();

        // Input arr2
        System.out.print("Enter size of arr2: ");
        int n = sc.nextInt();
        int[] arr2 = new int[n];
        System.out.println("Enter " + n + " sorted integers:");
        for (int i = 0; i < n; i++)
            arr2[i] = sc.nextInt();

        // Merge in-place
        merge(arr1, arr2, m, n);

        // Output
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));

        sc.close();
    }
}
