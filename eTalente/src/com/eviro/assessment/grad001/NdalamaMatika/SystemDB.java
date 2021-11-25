/*Author: Ndalama Matika
 * eTalente Java Graduate Assessment
 * Date: 25 November 2021
*/


package com.eviro.assessment.grad001.NdalamaMatika;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemDB {
	
	private static SystemDB INSTANCE = null;		
	
	//create Map with an ArrayList to store multiple values
	public Map<String, List<String>> map = new HashMap<String, List<String>>();

	List<String> savings1 = new ArrayList<String>();
	List<String> savings2 = new ArrayList<String>();
	List<String> current1 = new ArrayList<String>();
	List<String> current2 = new ArrayList<String>();
	
	private SystemDB() {
		//pre-populating values in the Map 

		// Savings account stores only accountNum and balance
		savings1.add("1");
		savings1.add("2000");
		
		savings2.add("2");		//account number
		savings2.add("5000");	//balance

		// Current account stores accountNum, balance, overdraft
		current1.add("3");			//account number
		current1.add("1000");		//balance
		current1.add("10000");		//overdraft limit

		current2.add("4");			//account number
		current2.add("-5000");		//balance
		current2.add("20000");		//overdraft limit
		
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
