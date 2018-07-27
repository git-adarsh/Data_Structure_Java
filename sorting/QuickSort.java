package com.dsj.sorting;

public class QuickSort extends SortingUtils {

	public QuickSort() {
		super();
	}

	@Override
	void sortArrayOfNumbers() {
		sortNumber(0, sizeOfArr - 1);
	}

	/**
	 * @param lowerIndex
	 *            Starting index of sub-array
	 * @param higherIndex
	 *            Ending index of sub-array
	 */
	private void sortNumber(int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {
			int indexOfMovedPivot = partitionOfNumbers(lowerIndex, higherIndex);
			sortNumber(lowerIndex, indexOfMovedPivot - 1);
			sortNumber(indexOfMovedPivot + 1, higherIndex);
		}
	}

	/**
	 * @param lowerIndex
	 *            Starting index of sub-array
	 * @param higherIndex
	 *            Ending index of sub-array
	 * @return the index which exceeds the altered position of current pivot by
	 *         1.
	 */
	private int partitionOfNumbers(int lowerIndex, int higherIndex) {
		int i = lowerIndex - 1;
		Object pivotElement = unsortedArr[higherIndex];
		int itr = lowerIndex;
		for (; itr < higherIndex; itr++) {
			if ((Double) unsortedArr[itr] <= (Double) pivotElement) {
				i++;
				if (i != itr) {
					swap(i, itr);
				}
			}
		}
		swap(++i, higherIndex);
		return i;
	}

	@Override
	void sortArrayOfStrings() {
		sortStrings(0, sizeOfArr - 1);
	}

	private void sortStrings(int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {
			int indexOfMovedPivot = partitionOfStrings(lowerIndex, higherIndex);
			sortStrings(lowerIndex, indexOfMovedPivot - 1);
			sortStrings(indexOfMovedPivot + 1, higherIndex);
		}
	}

	private int partitionOfStrings(int lowerIndex, int higherIndex) {
		int i = lowerIndex - 1;
		Object pivotElement = unsortedArr[higherIndex];
		int itr = lowerIndex;
		for (; itr < higherIndex; itr++) {
			if (((String) unsortedArr[itr]).length() <= ((String) pivotElement).length()) {
				i++;
				if (i != itr) {
					swap(i, itr);
				}
			}
		}
		swap(++i, higherIndex);
		return i;
	}

	/**
	 * Swap the values at index i and itr for the array.
	 */
	private void swap(int i, int itr) {
		Object tempHolder = unsortedArr[i];
		unsortedArr[i] = unsortedArr[itr];
		unsortedArr[itr] = tempHolder;
	}
}