package Recursion;

import java.util.Arrays;

/**
 * Created by oreany on 02.08.15.
 */
public class Permutation1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permutation(arr, arr.length);
    }

    private static void permutation(int[] arr, int size) {
        if (size < 2) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = size - 1; i >= 0; i--) {
                swap(arr, i, size - 1); //size, didn't swap!!!
                permutation(arr, size - 1);
            }
        }
    }

    private static void swap(int[] arr, int index0, int index1) {
        int tmp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = tmp;
    }
}
