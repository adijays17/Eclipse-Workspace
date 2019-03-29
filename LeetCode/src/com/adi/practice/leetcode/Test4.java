package com.adi.practice.leetcode;

public class Test4 {

	public static void main(String[] args) {
		String s1 = "We are the world";
		boolean flag = true;
		for (String s : s1.split(" ")) {
			for (String each : s.split("")) {
				if(!(each.charAt(0) >= 'a' && each.charAt(0) <= 'z') || (each.charAt(0) >= 'A' && each.charAt(0) <= 'Z')) {
		            System.out.println("is not an alphabet."+each);
				}
				if (flag) {
					System.out.print(each.toUpperCase());
					flag = false;
				} else {
					System.out.print(each);
					flag = true;
				}
			}
			System.out.print(" ");
		}
	}

}
