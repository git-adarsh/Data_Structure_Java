package com.dsj.sorting;

import java.util.Scanner;

public abstract class SortingUtils {

	int sizeOfArr;
	String dataType = "String";
	Object[] unsortedArr;

	SortingUtils(int sizeOfArr) {
		this.sizeOfArr = sizeOfArr;
		initializeUnsortedArr();
	}

	void initializeUnsortedArr() {
		System.out.println("Enter your items:");
		Scanner sc = new Scanner(System.in);
		String typeTestVar = sc.next();

		if (isOfTypeNumber(typeTestVar)) {
			dataType = "Number";
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
		return typeTestVar.matches("[0-9]+");
	}
	
	public void display() {
		for(int i = 0;i<sizeOfArr;i++) {
			System.out.print(unsortedArr[i]);
		}
	}

	abstract void sort();
	
	abstract void sortArrayOfNumbers();
	
	abstract void sortArrayOfStrings();
}
