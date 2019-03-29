package com.adi.practice.leetcode;

public class IntuitTest2 {

	public static void main(String[] args) {
		String input = "(25, 4) (1, -6)";
		int[] alldata = new int[4];
		int count = 0;
		for(String s : input.split("\\)")) {
			for(String each : s.split(",")) 
			{
				each = each.replace("(", "").trim();
				alldata[count] = Integer.parseInt(each);
			}
		}
		System.out.println(Math.sqrt(((alldata[0] - alldata[2])*(alldata[0] - alldata[2])) - ((alldata[1] - alldata[3])*alldata[1] - alldata[3])));
	}

}
