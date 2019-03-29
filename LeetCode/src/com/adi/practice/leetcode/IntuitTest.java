package com.adi.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IntuitTest {

	public static void main(String[] args) {
		List<String> input = new ArrayList<String>();
		input.add("[staging_server:base_server]");
		input.add("ram = 8G");
		input.add("envname = Staging");

		input.add("[dev_server:staging_server]");
		input.add("envname = Dev");

		input.add("[test_server:dev_server]");
		input.add("disk = 4G");

		input.add("[base_server]");
		input.add("ram = 16G");
		input.add("disk = 15G");

		input.add("[qa_server:base_server]");
		input.add("ram = 4G");

		parseConfiguration(input);
	}

	static void parseConfiguration(List<String> configurationLines) {
		Map<String, Map<String, String>> configurations = new TreeMap<>();
		String key = "";
		for (String eachLine : configurationLines) {
			if (eachLine.contains("[")) {
				eachLine = eachLine.replace("[", "");
				eachLine = eachLine.replace("]", "");
				if (eachLine.contains(":")) {
					String[] allCon = eachLine.split(":");
					Map<String, String> itsConf = new TreeMap<>();
					itsConf.put("parent", allCon[1]);
					configurations.put(allCon[0], itsConf);
					if (!configurations.containsKey(allCon[1]))
						configurations.put(allCon[1], new TreeMap<>());
					key = allCon[0];
				} else {
					key = eachLine;
					configurations.put(eachLine, new TreeMap<>());
				}
			} else if (eachLine.contains("=")) {
				Map<String, String> conf = configurations.get(key);
				String[] allConf = eachLine.split("=");
				conf.put(allConf[0].trim(), allConf[1].trim());
			} else {
				continue;
			}
		}
		for (Map.Entry<String, Map<String, String>> entry : configurations.entrySet()) {
			Map<String, String> conf = entry.getValue();
			if (conf.get("parent") != null) {
				populateParents(configurations, conf.get("parent"), entry.getKey());
			}
		}

		for (Map.Entry<String, Map<String, String>> entry : configurations.entrySet()) {
			System.out.println("[" + entry.getKey() + "]");
			for (Map.Entry<String, String> values : entry.getValue().entrySet()) {
				System.out.println(values.getKey() + " = " + values.getValue());
			}
			System.out.println("");
		}
	}

	static void populateParents(Map<String, Map<String, String>> configurations, String parent, String key) {
		Map<String, String> pConf = configurations.get(parent);
		if (pConf.get("parent") != null) {
			populateParents(configurations, pConf.get("parent"), parent);
		}
		Map<String, String> cConf = configurations.get(key);
		for (Map.Entry<String, String> entry : pConf.entrySet()) {
			if (!cConf.containsKey(entry.getKey())) {
				cConf.put(entry.getKey(), entry.getValue());
			}
		}
		cConf.remove("parent");
	}
}
