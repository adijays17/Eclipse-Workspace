package com.adi.practice.leetcode;

import java.util.Set;
import java.util.TreeSet;

public class Sulzer0 {

	static String ab;
	public Sulzer0() {
	}
	public static void main(String[] args) {
		int[] a = {3,2,1};
		System.out.println(solution(a));
		System.out.println(ab);
	}

	public static int solution(int[] A) {
		String a;
		a = "";
		Set<Integer> temp = new TreeSet<>();
		for (int each : A){
			temp.add(each);
		}
		if(a.endsWith("")) {
			
		}
		int max = 1;
		while(true) {
			if (!temp.contains(max)) {
				break;
			}
			max++;
		}
		return max;
    }

}
