package com.adi.practice.leetcode;

public class Test3 {

	public static void main(String[] args) {
		System.out.println(comp("aabaabbccd"));
	}

	public static String comp(String message) {
		if(message.isEmpty()) {
			return "";
		}
		StringBuilder updatedString = new StringBuilder();
		String prev = "";
		int count = 1;
		for (String each : message.split("")) {
			if (prev.equals(each)) {
				count++;
			} else {
				if (count == 1) {
					updatedString.append(each);
				} else {
					updatedString.append(String.valueOf(count));
					count = 1;
					updatedString.append(each);
				}
			}
			prev = each;
		}
		if (count != 1) {
			updatedString.append(String.valueOf(count));
		}
		return updatedString.toString();
	}

}
