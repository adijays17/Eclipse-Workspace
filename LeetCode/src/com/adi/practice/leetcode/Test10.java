package com.adi.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Test10 {

	public static void main(String[] args) {
		List<String> i = new ArrayList<>();
		i.add("121.18.19.20");
		i.add("2001:0db8:0000:0000:0000:ff00:0042:8329");
		i.add("bjhbsf askhdbfjbsdh sakjdbk");
		System.out.println(checkIPs(i));
	}

	public static List<String> checkIPs(List<String> ip_array) {
		List<String> output = new ArrayList<>();
		String ipv4 = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
		String ipv6 = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
		Pattern ipv4Pattern = Pattern.compile(ipv4, Pattern.CASE_INSENSITIVE);
		Pattern ipv6Pattern = Pattern.compile(ipv6, Pattern.CASE_INSENSITIVE);
		for (String ip : ip_array) {
			if (ipv4Pattern.matcher(ip).matches()) {
				output.add("IPv4");
			} else if (ipv6Pattern.matcher(ip).matches()) {
				output.add("IPv6");
			} else {
				output.add("Neither");
			}
		}
		return output;

	}
}
