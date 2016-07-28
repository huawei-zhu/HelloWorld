package com.od.face;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MyPrice {

	private static String[] red = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16" };

	private static String[] blue = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33" };

	private static final int LOOP = 10;

	private static String[][] container = new String[LOOP][15];

	private static Random random = new Random();

	public static void main(String[] args) {
		System.out.println("Beginning work...");

		for (int i = 0; i < LOOP; i++) {
			container[i][0] = red[random.nextInt(red.length)];

			Set<Integer> set = new TreeSet<>();
			do {
				set.add(random.nextInt(blue.length));
			} while (set.size() < 6);
			//System.out.println("blue data is " + set);

			Iterator<Integer> it = set.iterator();
			container[i][2] = blue[it.next()];
			container[i][4] = blue[it.next()];
			container[i][6] = blue[it.next()];
			container[i][8] = blue[it.next()];
			container[i][10] = blue[it.next()];
			container[i][12] = blue[it.next()];
		}
		
		System.out.println("Initialized End");

		for (int j = 0; j < LOOP; j++) {
			String key = container[j][0];
			if (container[j][1] != null) {
				continue;
			}
			int redCount = 1;
			int[] redMemory = new int[LOOP];
			redMemory[j] = 1;// current value

			for (int m = j + 1; m < LOOP; m++) {
				if (key.equals(container[m][0])) {
					++redCount;
					redMemory[m] = 1;
				}
			}
			for (int n = 0; n < LOOP; n++) {
				if (redMemory[n] == 1) {
					container[j][1] = redCount + "";
				}
			}
			redMemory = null;
		}

		System.out.println("Handle Red  End");

		for (int j = 0; j < LOOP; j++) {
			for (int k = 1; k < 7; k++) {
				String key = container[j][2 * k];
				if (container[j][2 * k + 1] != null) {
					continue;
				}

				int redCount = 1;
				int[][] redMemory = new int[LOOP][7];

				for (int h = j; h < LOOP; h++) {
					for (int t = 1; t < 7; t++) {
						if (key.equals(container[h][2 * t])) {
							++redCount;
							redMemory[h][t] = 1;
						}
					}
				}

				for (int n = j; n < LOOP; n++) {
					for (int r = 1; r < 7; r++) {

						if (redMemory[n][r] == 1) {
							container[j][2 * r + 1] = redCount + "";
						}
					}
				}
				redMemory = null;
			}
		}
		System.out.println("Handle Blue  End");
		for (int j = 0; j < LOOP; j++) {
			int count = 0;
			for (int k = 0; k < 7; k++) {
				count += Integer.parseInt(container[j][2 * k + 1]);
			}
			container[j][14] = count + "";
		}
		System.out.println("Sum End");
		bubbleSort();
		System.out.println("Sort End");

		
		for (int i = 0; i < 5; i++) {
			System.out.println("[" + i + "] = " + container[i][0] + ":[" + container[i][2] + "," + container[i][4] + "," + container[i][6] + ","
					+ container[i][8] + "," + container[i][10] + "," + container[i][12] + "], the score is "
					+ container[i][14]);
		}
		System.out.println("Print End");
	}

	public static void bubbleSort() {
		double temp;
		int size = LOOP;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				double ii = Double.parseDouble(container[i][14]);
				double jj = Double.parseDouble(container[j][14]);
				if (ii > jj) {
					temp = ii;
					ii = jj;
					jj = temp;
				}
				container[i][14] = ii + "";
				container[j][14] = jj + "";
			}
		}
	}

}
