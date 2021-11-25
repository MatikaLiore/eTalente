/*Author: Ndalama Matika
 * eTalente Java Graduate Assessment
 * Date: 25 November 2021
*/


package com.eviro.assessment.grad001.NdalamaMatika;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SavingsAccount implements AccountService{
	
	static SystemDB DB = SystemDB.getInstance();
	static List<String> value;
	static ArrayList<String> list;
	static BigDecimal balance;

	//Withdraw method implemented from the AccountService interface
	@Override
	public void withdraw(String accountNum, BigDecimal amountToWithdraw) {
		 if(accountNum.equals("1")) {accountNum = "101";}
		 if(accountNum.equals("2")) {accountNum = "102";}
		 if(accountNum.equals("3")) {accountNum = "103";}
		 if(accountNum.equals("4")) {accountNum = "104";}

		 list = new ArrayList<>();

		for(Map.Entry<String, List<String>> entry : DB.map.entrySet()) {			
			if(accountNum.equals(entry.getKey())) {
				list.add(entry.getValue().toString());
//				System.out.println("\n Account Exists ");
				}		
			}
		
			
			String str = "";
			String temp = "";
			double dbl;
			for(int i=0; i<= list.size() -1; i++) {
				str = list.get(i);
				String[] s = str.split(",");			

				if(s.length == 2) {
					accountNum = s[0];
					temp = s[1];
					temp = temp.replace('[', ' ');
					temp = temp.replace(']', ' ');
					dbl = Double.parseDouble(temp);
					balance = BigDecimal.valueOf(dbl);
					System.out.println("************************************");
					System.out.println("   Available balance: R" + balance);
					System.out.println("************************************");
					
					// calls the amountTowithdraw function in the Main Class
					amountToWithdraw = Main.amountTowithdraw();

					BigDecimal x = new BigDecimal("1000");		

					//takes the return value of the compare function for BigDecimals
					int compare; 
					
					// equivalent to: if (balance - amountToWithdraw >= 1000)
					compare = (balance.subtract(amountToWithdraw)).compareTo(x);
					
					 // returns 0 if equals, 
					// return 1 if balance > withdraw, 
					// return -1 if balance < withdraw
					if(compare == 0 || compare == 1) {
						balance = balance.subtract(amountToWithdraw);
						System.out.println("*********************************");
						System.out.println("New Balance is: R" + balance );
						System.out.println("*********************************");
					}
					if(compare == -1) {
						System.out.println(" Cannot Withdraw R" + amountToWithdraw + " \n Savings Account cannot exeed minimum of R1000");
					}
					
				}else {
					System.out.println("No Savings Account existing for this User. \n");
				}
			}
		}				
	
}
