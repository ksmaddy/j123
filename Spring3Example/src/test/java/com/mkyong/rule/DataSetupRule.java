package com.mkyong.rule;

import java.lang.reflect.Field;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.mkyong.annotation.DataSetup;
import com.mkyong.core.model.Customer;

public class DataSetupRule implements TestRule {

	private final Object target;
	
	/** pojo Object */
	private final Object dataObject;

   
    public DataSetupRule(Object target, Object dataObject) {
        this.target = target;
        this.dataObject = dataObject;
    }

    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
               
            	for (Field f : target.getClass().getFields()) {
                    if (f.isAnnotationPresent(DataSetup.class)) {
                        f.set(new Customer(), dataObject);
                    }
                }

                base.evaluate();

            }
        };
    }

}
