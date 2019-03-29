package com.adi.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SAIC1 {

	public static void main(String[] args) {
		String data = "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:01,400-234-090";
		System.out.println(solution(data));
	}

	public static int solution(String S) {
		Map<String, List<Integer>> allData = new HashMap<>();
		int maxBill = 0;
		String maxBillPh = "";
		String maxtime = "";
		for (String each : S.split("\n")) {
			String number = each.split(",")[1];
			String time = each.split(",")[0];
			String[] temp = time.split(":");
			int total = Integer.parseInt(temp[0]) * 3600 + Integer.parseInt(temp[1]) * 60 + Integer.parseInt(temp[2]);
			if (total > maxBill) {
				if (!maxBillPh.isEmpty()) {
					mapUpdater(allData, maxBillPh, maxtime);
				}
				maxBillPh = number;
				maxtime = time;
				maxBill = total;
			} else if (total < maxBill) {
				mapUpdater(allData, number, time);
			}else {
				int prevPhNum = Integer.parseInt(maxBillPh.replace("-", ""));
				int newPhNum = Integer.parseInt(number.replace("-", ""));
				if(newPhNum < prevPhNum) {
					if (!maxBillPh.isEmpty()) {
						mapUpdater(allData, maxBillPh, maxtime);
					}
					maxBillPh = number;
					maxtime = time;
					maxBill = total;
				}else {
					mapUpdater(allData, number, time);
				}
				
			}
		}
		if (allData.isEmpty() && !maxBillPh.isEmpty()) {
			mapUpdater(allData, maxBillPh, maxtime);
		}
		System.out.println(allData);
		int totalBill = 0;
		for (Map.Entry<String, List<Integer>> eachData : allData.entrySet()) {
			List<Integer> time = eachData.getValue();
			if (time.get(1) < 5 && time.get(0) == 0) {
				totalBill = totalBill + (time.get(1) * 60 + time.get(2)) * 3;
			} else {
				totalBill = totalBill + (time.get(0) * 60 + time.get(1)) * 150;

			}
		}
		return totalBill;
	}

	private static void mapUpdater(Map<String, List<Integer>> allData, String maxBillPh, String maxtime) {
		if (allData.containsKey(maxBillPh)) {
			List<Integer> prevTime = allData.get(maxBillPh);
			String[] tt = maxtime.split(":");
			Integer sec = prevTime.get(2) + Integer.parseInt(tt[2]);
			Integer min = 0;
			Integer hr = 0;
			if (sec >= 60) {
				sec = sec % 60;
				min = (sec / 60);
			}
			min = min + prevTime.get(1) + Integer.parseInt(tt[1]);
			if (min >= 60) {
				min = min + min % 60;
				hr = (hr / 60);
			}
			hr = hr + prevTime.get(0) + Integer.parseInt(tt[0]);
			List<Integer> times = new ArrayList<>();
			times.add(hr);
			times.add(min);
			times.add(sec);
			allData.put(maxBillPh, times);
		} else {
			String[] tt = maxtime.split(":");
			List<Integer> times = new ArrayList<>();
			times.add(Integer.parseInt(tt[0]));
			times.add(Integer.parseInt(tt[1]));
			times.add(Integer.parseInt(tt[2]));
			allData.put(maxBillPh, times);
		}
	}
}
