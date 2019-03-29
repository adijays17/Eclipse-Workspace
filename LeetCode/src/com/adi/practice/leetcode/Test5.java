package com.adi.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test5 {

	public static void main(String[] args) {
		List<Integer> beauty =  new ArrayList<>();
		beauty.add(3);
		beauty.add(7);
		beauty.add(5);
		beauty.add(6);
		beauty.add(8);
		List<Integer> u = new ArrayList<>();
		u.add(0);
		u.add(2);
		u.add(2);
		u.add(0);
		u.add(1);
		List<Integer> v = new ArrayList<>();
		v.add(1);
		v.add(0);
		v.add(3);
		v.add(4);
		v.add(5);
		List<Integer> t = new ArrayList<>();
		t.add(10);
		t.add(16);
		t.add(13);
		t.add(20);
		t.add(15);
		System.out.println(findBestPath(5, 5, 60, beauty, u, v, t));
	}

	public static int findBestPath(int n, int m, int max_t, List<Integer> beauty, List<Integer> u, List<Integer> v,
			List<Integer> t) {
		List<List<Integer>> allPaths = new ArrayList<>();
		for(int i=0; i<u.size(); i++) {
			//allPaths.add();		
		}
		
		return 0;
	}

}
