package com.eviro.assessment.grad001.NdalamaMatika;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemDB {
	
	private static SystemDB INSTANCE = null;		
	public Map<String, List<String>> map = new HashMap<String, List<String>>();	//create Map with an ArrayList to store multiple values
	List<String> savings1 = new ArrayList<String>();
	List<String> savings2 = new ArrayList<String>();
	List<String> current1 = new ArrayList<String>();
	List<String> current2 = new ArrayList<String>();
	
	private SystemDB() {
		//pre-populating values in the Map // Savings account stores only accountNum and balance
		savings1.add("1");
		savings1.add("2000");
		
		savings2.add("2");
		savings2.add("5000");

		// Current account stores accountNum, balance, overdraft
		current1.add("3");
		current1.add("1000");
		current1.add("10000");

		current2.add("4");
		current2.add("-5000");
		current2.add("20000");
		
		//put the values in the Map
		map.put("101", savings1);
		map.put("102", savings2);
		map.put("103", current1);
		map.put("104", current2);		
	}
	public static SystemDB getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new SystemDB();
		}
		return INSTANCE;
	}
	
}
