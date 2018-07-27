package com.dsj.sorting;

import java.util.Arrays;
import java.util.Scanner;

public abstract class SortingUtils {

	int sizeOfArr;
	boolean dataTypeNumber = false;
	Object[] unsortedArr;
	Scanner sc;

	/** Take the size of the input and initialize the unsorted array. */
	SortingUtils() {
		System.out.println("Enter the size of your list:");
		sc = new Scanner(System.in);
		this.sizeOfArr = sc.nextInt();
		initializeUnsortedArr();
	}

	/**
	 * Depending on the input provided, the sorting algorithm will sort the inputs.
	 * If a number is provided it sorts the number based on their value. If the
	 * input is anything but a number, it sorts based on its length.
	 */
	void initializeUnsortedArr() {
		System.out.println("Enter your items:");
		String typeTestVar = sc.next();

		if (isOfTypeNumber(typeTestVar)) {
			dataTypeNumber = true;
			unsortedArr = new Number[sizeOfArr];
			unsortedArr[0] = Double.parseDouble(typeTestVar);
			for (int i = 1; i < sizeOfArr; i++) {
				unsortedArr[i] = sc.nextDouble();
			}
		} else {
			unsortedArr = new String[sizeOfArr];
			unsortedArr[0] = typeTestVar;
			for (int i = 1; i < sizeOfArr; i++) {
				unsortedArr[i] = sc.next();
			}
		}
		sc.close();
	}

	private boolean isOfTypeNumber(String typeTestVar) {
		return typeTestVar.matches("^[-\\+]?\\d*.?\\d+$");
	}

	public void display() {
		System.out.println("The sorted array is: ");
		Arrays.stream(unsortedArr).forEach(System.out::println);
	}

	public void sort() {
		if (!dataTypeNumber) {
			this.sortArrayOfStrings();
		} else {
			this.sortArrayOfNumbers();
		}
	}

	/**
	 * To be implemented by each sorting class.
	 */
	abstract void sortArrayOfNumbers();

	abstract void sortArrayOfStrings();
}
