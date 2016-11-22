package com.od.face;

import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

//C:\workspace-git\git\HelloWorld\HelloWorld\target\classes
//java -Xms2048m -Xmx4096m com.od.face.MyPrice
public class MyPrice {

	private static String[] red = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16" };

	private static String[] blue = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33" };

	private static final int LOOP = 500 * 10000;
//	private static final int LOOP = 20;

	//private static String[][] container = new String[LOOP][15];

	private static String[][] min5Record = new String[5][8];

	private static Random random = new Random();

	public static void main(String[] args) {
		String[][] container = new String[LOOP][15];
		
		long begin = System.currentTimeMillis();
		System.out.println("Beginning work..., the current loop is " + LOOP);

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
		Map<String, Integer> redCache = new HashMap<>();
		for (int j = 0; j < LOOP; j++) {
			String key = container[j][0];
			if (redCache.containsKey(key)) {
				redCache.put(key, redCache.get(key) + 1);
			} else {
				redCache.put(key, 1);
			}
		}
		System.out.println("calculate Red 50%");
		for (int j = 0; j < LOOP; j++) {
			String key = container[j][0];
			if (redCache.containsKey(key)) {
				container[j][1] = redCache.get(key) + "";
			}
		}
		redCache = null;
		System.out.println("Handle Red End");
		////////////////////////////////////////////////
		
		Map<String, Integer> blueCache = new HashMap<>();
		for (int j = 0; j < LOOP; j++) {
			for (int k = 1; k < 7; k++) {
				String key = container[j][2 * k];
				if (blueCache.containsKey(key)) {
					blueCache.put(key, blueCache.get(key) + 1);
				} else {
					blueCache.put(key, 1);
				}
			}
		}
		System.out.println("calculate blue 50%");
		for (int j = 0; j < LOOP; j++) {
			for (int k = 1; k < 7; k++) {
				String key = container[j][2 * k];
				if (blueCache.containsKey(key)) {
					container[j][2 * k + 1] = blueCache.get(key) + "";
				}
			}
		}
		blueCache = null;
		System.out.println("Handle Blue End");
		
		for (int j = 0; j < LOOP; j++) {
			int count = 0;
			for (int k = 0; k < 7; k++) {
				count += Integer.parseInt(container[j][2 * k + 1]);
			}
			container[j][14] = count + "";
		}
		System.out.println("Sum End");
		bubbleSort(container);
		System.out.println("Sort End");
		
		for (int i = 0; i < 5; i++) {
			System.out.println("[" + i + "] = " + min5Record[i][0] + ":[" + min5Record[i][1] + "," + min5Record[i][2] + "," + min5Record[i][3] + ","
					+ min5Record[i][4] + "," + min5Record[i][5] + "," + min5Record[i][6] + "], the score is "
					+ min5Record[i][7]);
		}

		System.out.println("Print End");
		long end = System.currentTimeMillis() - begin;
		System.out.println("consume time [" + end + "] millisecond");
		System.out.println("format consume time [" + formatTime(end) + "]");
		
	}

	public static void bubbleSort(String[][] container) {
		//get min three record
		for (int i = 0; i < LOOP; i ++) {
			int val = Integer.parseInt(container[i][14]);
			for (int j = 0; j < 3; j++) {
				String minStr = min5Record[j][7];
				int minVal = Integer.parseInt(minStr == null ? "0" : minStr);
				if (minStr == null || minVal > val) {
					min5Record[j][0] = container[i][0];//red
					min5Record[j][1] = container[i][2];
					min5Record[j][2] = container[i][4];
					min5Record[j][3] = container[i][6];
					min5Record[j][4] = container[i][8];
					min5Record[j][5] = container[i][10];
					min5Record[j][6] = container[i][12];
					min5Record[j][7] = container[i][14];//sum
					
					break;
				}
			}
			
			//get max two record
			for (int j = 3; j < 5; j++) {
				String maxStr = min5Record[j][7];
				int maxVal = Integer.parseInt(maxStr == null ? "0" : maxStr);
				if (maxVal < val) {
					min5Record[j][0] = container[i][0];//red
					min5Record[j][1] = container[i][2];
					min5Record[j][2] = container[i][4];
					min5Record[j][3] = container[i][6];
					min5Record[j][4] = container[i][8];
					min5Record[j][5] = container[i][10];
					min5Record[j][6] = container[i][12];
					min5Record[j][7] = container[i][14];//sum
					
					break;
				}
			}
		}
	}
	
	public static String formatTime(long ms) {

		int ss = 1000;
		int mi = ss * 60;
		int hh = mi * 60;
		int dd = hh * 24;

		long day = ms / dd;
		long hour = (ms - day * dd) / hh;
		long minute = (ms - day * dd - hour * hh) / mi;
		long second = (ms - day * dd - hour * hh - minute * mi) / ss;
		long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

		String strDay = day < 10 ? "0" + day : "" + day;// day
		String strHour = hour < 10 ? "0" + hour : "" + hour;// hour
		String strMinute = minute < 10 ? "0" + minute : "" + minute;// minute
		String strSecond = second < 10 ? "0" + second : "" + second;// second
		String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;// milliSecond

		return strDay + " day " + strHour + " hour " + strMinute + " second " + strSecond + " second " + strMilliSecond + " milliSecond";
	}

}
