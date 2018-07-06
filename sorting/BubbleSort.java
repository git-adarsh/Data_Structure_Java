package com.dsj.sorting;

public class BubbleSort extends SortingUtils {

	public BubbleSort(int sizeOfArr) {
		super(sizeOfArr);
	}

	@Override
	public
	void sort() {
		if (dataType.equalsIgnoreCase("String")) {
			sortArrayOfStrings();
		} else {
			sortArrayOfNumbers();
		}
	}

	@Override
	void sortArrayOfNumbers() {
		for (int i = sizeOfArr - 1; i <= 0; i--) {
			for (int j = i; j <= 0; j--) {
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
		for (int i = sizeOfArr - 1; i <= 0; i--) {
			for (int j = i; j <= 0; j--) {
				if (((String) unsortedArr[j]).length() < ((String) unsortedArr[j - 1]).length()) {
					String temp = (String) unsortedArr[j];
					unsortedArr[j] = unsortedArr[j - 1];
					unsortedArr[j - 1] = temp;
				}
			}
		}

	}
}
