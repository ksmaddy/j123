package com.mkyong.statement;

import org.junit.runners.model.Statement;

import com.mkyong.core.model.Customer;

public class PojoSetupStatement extends Statement {

	private final Statement base;
	private final Object dataObject;
	private final Object target;

	public PojoSetupStatement(Statement base,Object dataObject,Object target){
		this.base = base;
		this.dataObject = dataObject;
		this.target = target;
	}

	@Override
	public void evaluate() throws Throwable {
		Customer customer = (Customer)dataObject;
		customer.setName("pats");
		customer.setAge(2);
		customer.setFlag(false);
		customer.setAddress("junk");
		target.getClass().getField("customer").set(target, customer);		
		try {
			System.out.println( "My Statement before evaluate" );
			base.evaluate();
			System.out.println( "My Statement after evaluate" );
		} finally {
			
		}
	}

}
