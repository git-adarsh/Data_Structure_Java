package com.dsj.sorting;

public class InsertionSort extends SortingUtils {

	int i;
	int j;

	public InsertionSort() {
		super();
	}

	@Override
	void sortArrayOfNumbers() {
		for (i = 1; i < sizeOfArr; i++) {
			for (j = i; j > 0; j--) {
				if ((Double) unsortedArr[j] < (Double) unsortedArr[j - 1]) {
					Double temp = (Double) unsortedArr[j];
					unsortedArr[j] = unsortedArr[j - 1];
					unsortedArr[j - 1] = temp;
				}
			}
		}
	}

	@Override
	void sortArrayOfStrings() {
		for (i = 1; i < sizeOfArr; i++) {
			for (j = i; j > 0; j--) {
				if (((String) unsortedArr[j]).length() < ((String) unsortedArr[j - 1]).length()) {
					String temp = (String) unsortedArr[j];
					unsortedArr[j] = unsortedArr[j - 1];
					unsortedArr[j - 1] = temp;
				}
			}
		}
	}
}
