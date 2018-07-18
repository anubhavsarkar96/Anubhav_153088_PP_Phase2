package com.cg.mypaymentapp.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;

public class TestClass {

	static WalletService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception 
	{
		Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust1=new Customer("Jack", "9490406126",new Wallet(new BigDecimal(9000)));
		 Customer cust2=new Customer("Anubhav", "9951264163",new Wallet(new BigDecimal(6000)));
		 Customer cust3=new Customer("Tony", "9949322164",new Wallet(new BigDecimal(7000)));
				
		 data.put("9490406126", cust1);
		 data.put("9951264163", cust2);	
		 data.put("9949322164", cust3);	
			service= new WalletServiceImpl(data);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=InvalidInputException.class)
	public void testCreateAccount1() 
	{
		service.createAccount(null, "8019602201", new BigDecimal(1500));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount2() 
	{
		service.createAccount("", "8019602201", new BigDecimal(1500));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount3() 
	{
		service.createAccount("eric", "999", new BigDecimal(1500));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount4() 
	{
		service.createAccount("eric", "", new BigDecimal(1500));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount5() 
	{
		service.createAccount("", "", new BigDecimal(1500));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount6() 
	{
		service.createAccount("Jack", "94904061266", new BigDecimal(9000));
	}

	@Test
	public void testCreateAccount7() 
	{
		Customer actual=service.createAccount("Elsa", "9666570195", new BigDecimal(5000));
		Customer expected=new Customer("Elsa", "9666570195", new Wallet(new BigDecimal(5000)));
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testCreateAccount8() 
	{
		Customer actual=service.createAccount("Harry", "8754922472", new BigDecimal(0));
		Customer expected=new Customer("Harry", "8754922472", new Wallet(new BigDecimal(0)));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCreateAccount9() 
	{
		Customer actual=service.createAccount("Harry", "8754922472", new BigDecimal(5000.75));
		Customer expected=new Customer("Harry", "8754922472", new Wallet(new BigDecimal(5000.75)));
		
		assertEquals(expected, actual);
	}


	
	@Test(expected=InvalidInputException.class)
	public void testShowBalance10() 
	{
		service.showBalance(null);		
	}
	
	
	
	
	
	@Test(expected=InvalidInputException.class)
	public void testShowBalance11() 
	{
		service.showBalance("12345");		
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testShowBalance12() 
	{
		service.showBalance("9900112218");		
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testShowBalance13() 
	{
		service.showBalance("94904061262");		
	}
	
	
	

	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer14() 
	{
		service.fundTransfer("9948484810", "9949322164", new BigDecimal(5000));		
	}
	
	
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer15() 
	{
		service.fundTransfer("9949322164", "99493221645", new BigDecimal(5000));		
	}

	
//	@Test(expected=InsufficientBalanceException.class)
//	public void testFundTransfer16() 
//	{
//		service.fundTransfer("9490406126", "9949322164", new BigDecimal(12000));		
//	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer17() 
	{
		service.fundTransfer("9490406126", "9949322164", new BigDecimal(0));		
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer18() 
	{
		service.fundTransfer("9490406126", "", new BigDecimal(0));		
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer19() 
	{
		service.fundTransfer("", "9949322164", new BigDecimal(500));		
	}
//	
//	@Test(expected=InsufficientBalanceException.class)
//	public void testFundTransfer20() 
//	{
//		Customer customer=service.fundTransfer("9490406126", "9949322164", new BigDecimal(15000));	
//	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer21() 
	{
		service.fundTransfer("", "9949322164", new BigDecimal(-100));		
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer22() 
	{
		service.fundTransfer("", "", new BigDecimal(500));		
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer23() 
	{
		service.fundTransfer(null, null, new BigDecimal(0));		
	}
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer24() 
	{
		service.fundTransfer("9949322164", "9951264163", new BigDecimal(0));		
	}


	@Test(expected=InvalidInputException.class)
	public void testDepositAmount25() 
	{
		service.depositAmount("", new BigDecimal(500));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testDepositAmount26() 
	{
		service.depositAmount("8019602201", new BigDecimal(500));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testDepositAmount27() 
	{
		service.depositAmount("8019602201", new BigDecimal(0));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testDepositAmount28() 
	{
		service.depositAmount("9949322164", new BigDecimal(-1000));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testDepositAmount29() 
	{
		service.depositAmount("99493221645", new BigDecimal(200000));
	}
}
