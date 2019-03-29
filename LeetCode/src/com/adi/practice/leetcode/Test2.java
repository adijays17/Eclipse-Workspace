package com.adi.practice.leetcode;

public class Test2 {

	public static void main(String[] args) {
		String num = "7";
		int sum = 0;
		for (int i = 0; i <= Integer.parseInt(num); i++) {
			if(i%5==0 || i%7==0) {
				continue;
			}
			sum = sum + i;
		}
		System.out.println(sum);
	}

}
