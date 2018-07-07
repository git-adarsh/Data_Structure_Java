package com.dsj.sorting;

public class BubbleSort extends SortingUtils {

	int i;
	int j;

	public BubbleSort() {
		super();
	}

	@Override
	void sortArrayOfNumbers() {
		for (i = 0; i < sizeOfArr - 1; i++) {
			for (j = 0; j < sizeOfArr - i - 1; j++) {
				if ((Double) unsortedArr[j] > (Double) unsortedArr[j + 1]) {
					Double temp = (Double) unsortedArr[j];
					unsortedArr[j] = unsortedArr[j + 1];
					unsortedArr[j + 1] = temp;
				}
			}
		}
	}

	@Override
	void sortArrayOfStrings() {
		for (i = 0; i < sizeOfArr - 1; i++) {
			for (j = 0; j < sizeOfArr - i - 1; j++) {
				if (((String) unsortedArr[j]).length() > ((String) unsortedArr[j + 1]).length()) {
					String temp = (String) unsortedArr[j];
					unsortedArr[j] = unsortedArr[j + 1];
					unsortedArr[j + 1] = temp;
				}
			}
		}

	}
}
