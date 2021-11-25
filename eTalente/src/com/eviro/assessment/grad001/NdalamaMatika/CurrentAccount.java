/*Author: Ndalama Matika
 * eTalente Java Graduate Assessment
 * Date: 25 November 2021
*/


package com.eviro.assessment.grad001.NdalamaMatika;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CurrentAccount implements AccountService{
	
	static SystemDB DB = SystemDB.getInstance();
	static List<String> value;
	static ArrayList<String> list;
	static BigDecimal balance;
	static BigDecimal overdraft;
	
	//Withdraw method implemented from the AccountServce interface
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
		double dbl1;
		double dbl2;
		for(int i=0; i<= list.size() -1; i++) {
			str = list.get(i);
			String[] s = str.split(",");			

			if(s.length == 3) {
				accountNum = s[0];
				dbl1 = Double.parseDouble(s[1]);
				balance = BigDecimal.valueOf(dbl1);
				temp = s[2];
				temp = temp.replace('[', ' ');
				temp = temp.replace(']', ' ');
				dbl2 = Double.parseDouble(temp);
				overdraft = BigDecimal.valueOf(dbl2);
				System.out.println("*********************************************************");
				System.out.println(" balance: R" + balance + " overdraft: R" + overdraft);
				System.out.println("*********************************************************");
				
				amountToWithdraw = Main.amountTowithdraw();
				
				//equivalent to: AvailBalance = balance + overdraft
				BigDecimal AvailBalance = balance.add(overdraft);
				
				//takes the return value of the compare function for BigDecimals
				int compare; 
				int compare2; 
				
				// equivalent to: if (Availbalance > 0)
				compare = AvailBalance.compareTo(new BigDecimal("0"));
				compare2 = (AvailBalance.subtract(amountToWithdraw)).compareTo(new BigDecimal("0"));
				
				// returns 0 if equals, 
				// return 1 if balance > withdraw, 
				// return -1 if balance < withdraw
				if(compare == 1) {
					if(compare2 == 1) {
						AvailBalance = AvailBalance.subtract(amountToWithdraw);
						balance = balance.subtract(amountToWithdraw);
						System.out.println("*************************************");
						System.out.println("Balance: R" + balance);
						System.out.println("Available Balance: R" + AvailBalance);
						System.out.println("*************************************");
					}else {
						System.out.println("Withdrawal Amount Exceeds Available balance");
					}
				}else {
					System.out.println("Insufficient Funds");
				}
				
			}else {
				System.out.println("No Current Account exists for this User. \n");
			}
		}
		
	}

}
