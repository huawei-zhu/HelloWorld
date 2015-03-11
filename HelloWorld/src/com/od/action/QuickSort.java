package com.od.action;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 23, 4, 12, 545, 65, 78, 8, 3, 2, 333, 5 };
		quickSort(array, 0, array.length - 1);
		Arrays.stream(array).forEach((int i) -> System.out.print( i + ","));
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int middle = getMiddle(array, low, high);
			quickSort(array, low, middle);
			quickSort(array, middle + 1, high);
		}

	}

	private static int getMiddle(int[] array, int low, int high) {
		int temp = array[low];
		while (low < high) {
			while (low < high && array[high] > temp) {
				high--;
			}
			array[low] = array[high];

			while (low < high && array[low] < temp) {
				low++;
			}
			array[high] = array[low];
		}
		array[low] = temp;
		return low;
	}

}
