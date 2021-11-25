package com.eviro.assessment.grad001.NdalamaMatika.ExceptionClasses;

@SuppressWarnings("serial")
public class WithdrawalAmountTooLargeException extends Exception{
	
	public WithdrawalAmountTooLargeException(String errMessage) {
		super(errMessage);
	}
	
}
