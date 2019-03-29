package com.adi.practice.leetcode;

public class IntervalListIntersections {
	public class Interval implements Comparable<Interval>{
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Interval o) {
			if(start == o.start) {
				
			}else {
				
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
