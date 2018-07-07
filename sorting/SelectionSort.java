package com.dsj.sorting;

public class SelectionSort extends SortingUtils {
	int i;
	int j;

	public SelectionSort() {
		super();
	}

	@Override
	void sortArrayOfNumbers() {
		for (i = 0; i < sizeOfArr; i++) {
			findMinAndSwapNumbers(i);
		}
	}

	@Override
	void sortArrayOfStrings() {
		for (i = 0; i < sizeOfArr; i++) {
			findMinAndSwapStrings(i);
		}
	}

	void findMinAndSwapNumbers(int i) {
		Double min = (Double) unsortedArr[i];
		int minIndex = i;
		int itr = i;
		for (; itr < sizeOfArr; itr++) {
			if (min > (Double) unsortedArr[itr]) {
				min = (Double) unsortedArr[itr];
				minIndex = itr;
			}
		}
		if (i != minIndex) {
			Double temp = (Double) unsortedArr[i];
			unsortedArr[i] = unsortedArr[minIndex];
			unsortedArr[minIndex] = temp;
		}

	}

	void findMinAndSwapStrings(int i) {
		String min = (String) unsortedArr[i];
		int minIndex = i;
		int itr = i;
		for (; itr < sizeOfArr; itr++) {
			if (min.length() > ((String) unsortedArr[itr]).length()) {
				min = (String) unsortedArr[itr];
				minIndex = itr;
			}
		}
		if (i != minIndex) {
			String temp = (String) unsortedArr[i];
			unsortedArr[i] = unsortedArr[minIndex];
			unsortedArr[minIndex] = temp;
		}

	}
}
