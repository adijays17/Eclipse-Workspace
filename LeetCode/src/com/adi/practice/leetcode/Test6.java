package com.adi.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test6 {

	public static void main(String[] args) {
		String s = "1,2,3,4,6;5";
		int sum = Integer.parseInt(s.split(";")[1]);
		String allData = s.split(";")[0];
		List<Integer> temp = new ArrayList<>();
		String out = "";
		for(String s1 : allData.split(",")) {
			temp.add(Integer.parseInt(s1));
		}
		for(Integer each : temp) {
			if (temp.contains(sum - each) && each<=(sum - each)){
				out = out + each+","+(sum - each)+";";
			}
		}
		if(out.isEmpty()) {
			System.out.println("NULL");
		}else {
			System.out.println(out.substring(0, out.length()-1));
		}
	}

}
