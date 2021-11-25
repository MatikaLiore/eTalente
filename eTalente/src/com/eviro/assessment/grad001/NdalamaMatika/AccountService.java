/*Author: Ndalama Matika
 * eTalente Java Graduate Assessment
 * Date: 25 November 2021
*/

package com.eviro.assessment.grad001.NdalamaMatika;

import java.math.BigDecimal;

//Interface to be implemented by Current and Savings Account
public interface AccountService {

	 public void withdraw(String accountNum, BigDecimal amountToWithdraw);
	
}
