package com.od.face;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;



//java -Xms16m -Xmx32m com.od.face.MyStringBuilder
public class MyStringBuilder {
	
	public static void main(String[] args) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<Object[]> list = new ArrayList<>();
		int count = 50000;
		for (int i = 1; i < count; i++) {
			list.add(new Object[]{"90752894", "WWW", new Date(), 999337251813L, 158465});
		}
		System.out.println("size: " + list.size());
		String str = geneDiskAllocCSV1(list);
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("I will either reach here or die trying");
	}
	
	protected static String geneDiskAllocCSV1(List<Object[]> reportContent) {
		StringBuilder sb = new StringBuilder();
		sb.append("Account Number").append(",");
		sb.append("Account Type").append(",");
		sb.append("Last file added/updated date").append(",");
		sb.append("Total used disk space (bytes)").append(",");
		sb.append("Number of files").append("\n");
		for (Object[] e : reportContent) {
			String accountNum = StringEscapeUtils.escapeCsv((String) e[0]);
			String accountType = StringEscapeUtils.escapeCsv((String) e[1]);
			Object time = e[2];
			Object size = e[3];
			Object count = e[4];
			sb.append(accountNum).append(",");
			sb.append(accountType).append(",");
			sb.append(time).append(",");
			sb.append(size).append(",");
			sb.append(count).append("\n");
		}
		return sb.toString();
	}

}
