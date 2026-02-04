package util;

public class ArrayUtil {
    public static int[] add(int[] arr, int value) {
        // add value 100 => end arr => [10, 20, 30, 100]
        // Step 1: Create a new memory area with a size equal to the old array length + 1.
        int[] brr = new int[arr.length + 1];

        // Step 2: Copy the values from the old array to the new array.
        for(int i = 0; i < arr.length; i++) {
            brr[i] = arr[i];
        }

        //  Step 3: Assign the element to be added to the last position of the new array.
        // brr[brr.length - 1] = 100;
        brr[arr.length] = value;

        // Bước 4: Make the original array variable reference the new memory area.
        return brr;
    }
}