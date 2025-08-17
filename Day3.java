import java.util.Scanner;

public class FindDuplicateNumber {

    // Method to find duplicate using Floyd's Cycle Detection
    public static int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        // Phase 1: Detect cycle
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Phase 2: Find entry point (duplicate number)

        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of array (n+1): ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter " + size + " integers (range 1 to " + (size - 1) + "):");

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Output

        System.out.println("Duplicate number: " + findDuplicate(arr));

        sc.close();
    }
  }
