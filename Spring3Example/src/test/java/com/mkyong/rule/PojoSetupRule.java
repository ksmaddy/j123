package com.mkyong.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.mkyong.statement.PojoSetupStatement;

public class PojoSetupRule implements TestRule {
	 /** The target test. */
	private final Object target;
	/** pojo Object */
	private final Object dataObject;

    public PojoSetupRule(Object target,Object dataObject) {
        this.target = target;
        this.dataObject = dataObject;
    }

	public Statement apply(Statement statement, Description description) {
		// TODO Auto-generated method stub
		return new PojoSetupStatement(statement,dataObject,target);
	}

}
