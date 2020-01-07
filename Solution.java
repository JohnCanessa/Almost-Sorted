import java.util.Scanner;

/*
 *
 */
public class Solution {

  /*
   * Reverse the specified elements in an array. If the array is sorted return
   * true; otherwise undo the reversal and return false.
   */
  static boolean reverse(int[] arr, int start, int end) {

    // **** reverse the elements in the specified range ****
    for (int i = start, j = end; i < j; i++, j--) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    // **** determine if array if sorted ****
    boolean sorted = isSorted(arr);

    // **** check if array is now sorted ****
    if (sorted) {
      return true;
    }

    // **** undo reversal of elements (not needed because there are no additional
    // operations) ****
    for (int i = start, j = end; i < j; i++, j--) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    // **** array was NOT sorted after reversal ****
    return false;
  }

  /*
   * Swap the two values in the specified array. If array is sorted return true;
   * otherwise undo the swap and return false.
   */
  static boolean swap(int[] arr, int start, int end) {

    // **** swap the specified entries in the array ****
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;

    // **** determine if array if sorted ****
    boolean sorted = isSorted(arr);

    // **** check if array is sorted ****
    if (sorted) {
      return true;
    }

    // **** undo swap ****
    temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;

    // **** array was NOT sorted after swap ****
    return false;
  }

  /*
   * Check if array is sorted.
   */
  static boolean isSorted(int[] arr) {

    // **** check if array has a single entry ****
    if (arr.length == 1) {
      return true;
    }

    // **** traverse the array checking consecutive elements ****
    for (int i = 1; i < arr.length; i++) {

      // **** check if out of order ****
      if (arr[i - 1] > arr[i]) {

        // **** array is NOT sorted ****
        return false;
      }
    }

    // **** array is sorted ****
    return true;
  }

  /*
   * Complete the almostSorted function below.
   */
  static void almostSorted(int[] arr) {

    // **** check if array is sorted ****
    boolean sorted = isSorted(arr);

    // **** array is sorted ****
    if (sorted) {
      System.out.println("yes");
      return;
    }

    // **** declare start and end elements ****
    int start = 0;
    int end = 0;

    // **** look for start element out of order (left to right) ****
    for (int i = 0; i < (arr.length - 1); i++) {
      if (arr[i] > arr[i + 1]) {
        start = i;
        break;
      }
    }

    // // ???? ????
    // System.out.println("almostSorted <<< start: " + start);

    // **** look for end element out of order (right to left ) ****
    for (int i = arr.length - 1; i > 0; i--) {
      if (arr[i] < arr[i - 1]) {
        end = i;
        break;
      }
    }

    // // ???? ????
    // System.out.println("almostSorted <<< end: " + end);

    // **** swap elements ****
    sorted = swap(arr, start, end);

    // **** array if array is sorted ****
    if (sorted) {
      System.out.println("yes");
      System.out.println("swap " + (start + 1) + " " + (end + 1));
      return;
    }

    // **** reverse elements ****
    sorted = reverse(arr, start, end);

    // **** check if array is sorted ****
    if (sorted) {
      System.out.println("yes");
      System.out.println("reverse " + (start + 1) + " " + (end + 1));
      return;
    }

    // **** could not find a way to sort the array ****
    System.out.println("no");

  }

  // **** open a scanner ****
  private static final Scanner scanner = new Scanner(System.in);

  /*
   * Test scaffolding.
   */
  public static void main(String[] args) {

    // **** read the number of elements to process ****
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    // ???? ????
    System.out.println("main <<< n: " + n);

    // **** read the array ****
    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    // **** populate the array ****
    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    // **** determine if the array can be sorted ****
    almostSorted(arr);

    // **** close the scanner ****
    scanner.close();
  }
}