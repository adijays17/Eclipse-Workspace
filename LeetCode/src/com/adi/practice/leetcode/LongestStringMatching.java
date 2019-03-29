package com.adi.practice.leetcode;

public class LongestStringMatching {

	public static void main(String[] args) {
		System.out.println(kire());
	}
	
	public static String kire() {
		try {
			//throw new Exception();
			return "1";
		}catch(Exception e) {
			System.out.println("2");
			return "4";
		}finally {
			return "3";			
		}
	}
}
