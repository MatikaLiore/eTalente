/*Author: Ndalama Matika
 * eTalente Java Graduate Assessment
 * Date: 25 November 2021
*/

package com.eviro.assessment.grad001.NdalamaMatika;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
	
	static String accountNum = "";
	static BigDecimal amountToWithdraw;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("******************************************");
		System.out.println("********************************************************** \n");
		System.out.println("	        HELLO, WELCOME TO ENVIRO-BANK \n");
		System.out.println("********************************************************** \n");
		
		int check;
		
		System.out.println(" Type 1 for a Savings Account, Type 2 for a Current Account ");
		System.out.println("------------------------------------------------------------");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		check = sc.nextInt();
		System.out.println("---");
		switch (check){
			case 1:
				Savings();
				break;
			case 2:
				Current();
				break;
			default:
				System.err.println("-----------------------------------------");
				System.err.println("Invalid Selection, Select only 1 or 2");
				System.err.println("-----------------------------------------");
				break;
		}		
	}
	
	public static void Savings() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String accountNum = "";
		System.out.println("-----------------------------------------------");
		System.out.println(" Please Enter your Savings Account Number");		
		System.out.println("-----------------------------------------------");
		accountNum = sc.nextLine();
		
		SavingsAccount savings = new SavingsAccount();		
		savings.withdraw(accountNum, amountToWithdraw);
	}
	
	public static void Current() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String accountNum = "";
		
		System.out.println("-----------------------------------------------");
		System.out.println(" Please Enter your Current Account Number");
		System.out.println("-----------------------------------------------");
		accountNum = sc.nextLine();

		CurrentAccount current = new CurrentAccount();
		current.withdraw(accountNum, amountToWithdraw);

	}
	
	public static BigDecimal amountTowithdraw() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BigDecimal withdraw;
		System.out.println("-----------------------------------------");
		System.out.println("Please Enter Amount To Withdraw: ");
		System.out.println("-----------------------------------------");
		withdraw = sc.nextBigDecimal();
		System.out.println("___");
		
		return withdraw;
	}

}
