package com.demo.sort;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head;
        int j = tail;
        int median = arr[(head + tail) / 2];
        while (i < j) {
            while (arr[i] < median) {
                i++;
            }
            while (arr[j] > median) {
                j--;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            } else if (i == j) {
                i++;
            }

        }
        sort(arr, head, j);
        sort(arr, i, tail);
    }

    public static void main(String[] arg) {
        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        QuickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
