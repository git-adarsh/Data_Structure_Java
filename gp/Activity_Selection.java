package com.dsj.gp;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Activity_Selection {

	int numOfActivities;
	Scanner sc;

	List<Activity_Sel_Pair> listOfActivities = new ArrayList<>();

	public Activity_Selection() {
		System.out.println("Enter the number of activities: ");

		sc = new Scanner(System.in);
		numOfActivities = sc.nextInt();

		takeInput();

		activitySelection();
	}

	private void activitySelection() {
		//At least one activity can be performed.
		int maxActivities = 1;
		
		sortListByFinishTime();

		System.out.println("Activities to perform are: ");
		
		int helper = 0;
		listOfActivities.get(helper).display();
		
		for (int itr = 1; itr < numOfActivities; itr++) {
			if (listOfActivities.get(helper).finishValue <= listOfActivities.get(itr).startValue) {
				maxActivities++;
				helper++;
				listOfActivities.get(itr).display();
			}
		}
		System.out.println("The maximum activities that can be performed are: " + maxActivities);
	}

	/**
	 * Sort the list of "Pair" objects based on its finish times.
	 */
	private void sortListByFinishTime() {
		Collections.sort(listOfActivities, Comparator.comparing(Activity_Sel_Pair::getFinishValue));
	}

	/**
	 * For the {@link numOfActivities}, loop through to get pair of Start and
	 * finish times.
	 */
	private void takeInput() {
		for (int i = 0; i < numOfActivities; i++) {
			System.out.println(MessageFormat.format("Enter activity no: {0}''s start time and finish time:", i + 1));
			listOfActivities.add(new Activity_Sel_Pair(sc.nextInt(), sc.nextInt()));
		}
		sc.close();
	}
}
