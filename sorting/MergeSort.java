package com.dsj.sorting;

public class MergeSort extends SortingUtils {

	public MergeSort() {
		super();
	}

	/**
	 * Recursively divide the array based on lowerIndex, HigherIndex, and
	 * middleIndex
	 */
	private void partition(int lowerIndex, int rightIndex) {
		if (lowerIndex < rightIndex) {
			int m = (lowerIndex + rightIndex) / 2;
			partition(lowerIndex, m);
			partition(m + 1, rightIndex);
			if (dataTypeNumber)
				sortArrayOfNumbers(lowerIndex, m, rightIndex);
			else
				sortArrayOfStrings(lowerIndex, m, rightIndex);
		}
	}

	/**
	 * Merge-Sort the array of Strings. Any input that is not a number, is
	 * considered a string
	 */
	private void sortArrayOfStrings(int lowerIndex, int middleIndex, int rightIndex) {

		int leftArrLength = middleIndex - lowerIndex + 1;
		int rightArrLength = rightIndex - middleIndex;

		Object leftArr[] = new Object[leftArrLength];
		Object rightArr[] = new Object[rightArrLength];

		initializeTempArrays(leftArr, rightArr, lowerIndex, middleIndex, leftArrLength, rightArrLength);

		int leftItr = 0, rightItr = 0;
		int insertIndex = lowerIndex;

		while (leftItr < leftArrLength && rightItr < rightArrLength) {
			if (leftArr[leftItr].toString().length() <= rightArr[rightItr].toString().length()) {
				unsortedArr[insertIndex] = leftArr[leftItr];
				leftItr++;
			} else {
				unsortedArr[insertIndex] = rightArr[rightItr];
				rightItr++;
			}
			insertIndex++;
		}
		insertElementsFromTempArrs(leftItr, leftArrLength, insertIndex, rightItr, rightArrLength, rightArr, leftArr);
	}

	/** Merge-Sort the array of numbers. */
	private void sortArrayOfNumbers(int lowerIndex, int middleIndex, int rightIndex) {

		// Size of array from lowerIndex to middleIndex
		int leftArrLength = middleIndex - lowerIndex + 1;

		// Size of array from middleIndex to higherIndex
		int rightArrLength = rightIndex - middleIndex;

		// This array will contain elements from lowerIndex to middleIndex
		Object leftArr[] = new Object[leftArrLength];

		// This array will contain elements from from middleIndex+1 to
		// higherIndex
		Object rightArr[] = new Object[rightArrLength];

		initializeTempArrays(leftArr, rightArr, lowerIndex, middleIndex, leftArrLength, rightArrLength);

		int leftItr = 0, rightItr = 0;
		int insertIndex = lowerIndex;

		while (leftItr < leftArrLength && rightItr < rightArrLength) {
			if ((Double) leftArr[leftItr] <= (Double) rightArr[rightItr]) {
				unsortedArr[insertIndex] = leftArr[leftItr];
				leftItr++;
			} else {
				unsortedArr[insertIndex] = rightArr[rightItr];
				rightItr++;
			}
			insertIndex++;
		}
		insertElementsFromTempArrs(leftItr, leftArrLength, insertIndex, rightItr, rightArrLength, rightArr, leftArr);
	}

	private void initializeTempArrays(Object[] leftArr, Object[] rightArr, int l, int m, int leftArrLength, int rightArrLength) {
		for (int i = 0; i < leftArrLength; i++) {
			leftArr[i] = unsortedArr[i + l];
		}

		for (int j = 0; j < rightArrLength; j++) {
			rightArr[j] = unsortedArr[m + j + 1];
		}
	}

	/**
	 * Insert those elements in original that were not iterated in the while
	 * loop.
	 */
	private void insertElementsFromTempArrs(int leftItr, int leftArrLength, int insertIndex, int rightItr, int rightArrLength,
			Object[] rightArr, Object[] leftArr) {
		for (; leftItr < leftArrLength; leftItr++) {
			unsortedArr[insertIndex] = leftArr[leftItr];
			insertIndex++;
		}
		for (; rightItr < rightArrLength; rightItr++) {
			unsortedArr[insertIndex] = rightArr[rightItr];
			insertIndex++;
		}
	}

	@Override
	void sortArrayOfNumbers() {
		partition(0, sizeOfArr - 1);
	}

	@Override
	void sortArrayOfStrings() {
		partition(0, sizeOfArr - 1);
	}
}