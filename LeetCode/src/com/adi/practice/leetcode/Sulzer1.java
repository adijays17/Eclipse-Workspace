package com.adi.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Sulzer1 {

	public static void main(String[] args) {
		String names = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
		System.out.println(solution(names, "Example"));
	}

	public static String solution(String S, String C) {
		String[] allNames = S.split(";");
		List<String> allEmails = new ArrayList<>();
		for (String each : allNames) {
			String[] names = each.trim().split(" ");
			String email = "";
			if (names.length == 3) {
				email = names[0] + "_" + names[2] + "@" + C + ".com";
			} else if (names.length == 2) {
				email = names[0] + "_" + names[1] + "@" + C + ".com";
			}
			if (allEmails.contains(email.toLowerCase())) {
				int count = 2;
				while (true) {
					String tempEmail = email.replace("@", String.valueOf(count) + "@");
					if (allEmails.contains(tempEmail.toLowerCase())) {
						count++;
						continue;
					} else {
						tempEmail = tempEmail.replaceAll("-", "");
						allEmails.add(tempEmail.toLowerCase());
						break;
					}
				}
			} else {
				email = email.replaceAll("-", "");
				allEmails.add(email.toLowerCase());
			}
		}
		return String.join("; ", allEmails);
	}
}
