package com.adi.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Sulzer2 {

	public static void main(String[] args) {
		System.out.println(solution("fdxg", "gfdsa"));
	}

	public static int solution(String A, String B) {

		Map<String, Integer> mapA = new HashMap<>();
		Map<String, Integer> mapB = new HashMap<>();
		int out = 0;
		for (String a : A.split("")) {
			if (mapA.containsKey(a)) {
				mapA.put(a.toLowerCase(), mapA.get(a) + 1);
			} else {
				mapA.put(a.toLowerCase(), 1);
			}
		}

		for (String b : B.split("")) {
			if (mapB.containsKey(b)) {
				mapB.put(b.toLowerCase(), mapB.get(b) + 1);
			} else {
				mapB.put(b.toLowerCase(), 1);
			}
		}

		for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
			if (mapB.containsKey(entry.getKey())) {
				int temp = mapB.get(entry.getKey()) - entry.getValue();
				if(temp<0) {
					temp = temp*-1;
				}
				out = out+ temp;
			}else {
				out = out + entry.getValue();
			}	
			mapB.remove(entry.getKey());
		}
		
		for (Map.Entry<String, Integer> entry : mapB.entrySet()) {
			if (mapA.containsKey(entry.getKey())) {
				continue;
			}else {
				out = out + entry.getValue();
			}	
			mapA.remove(entry.getKey());
		}
		return out;
	}
}
