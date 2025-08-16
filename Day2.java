public class MissingNumber {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1; // Because one number is missing
        int totalSum = n * (n + 1) / 2; // Sum of numbers from 1 to n
        int arrSum = 0;

        for (int num : arr) {
            arrSum += num;
        }

        return totalSum - arrSum; // Missing number
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5}; // Example input
        int missing = findMissingNumber(arr);
        System.out.println("Missing number: " + missing);
    }
}
