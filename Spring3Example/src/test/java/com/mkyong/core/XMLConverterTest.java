package com.mkyong.core;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.core.model.Customer;
import com.mkyong.rule.MockRule;
import com.mkyong.rule.PojoSetupRule;
import com.mkyong.rule.SpringContextRule;

public class XMLConverterTest {
	static XMLConverterTest test = new XMLConverterTest();
	@ClassRule
	public static TestRule contextRule = new SpringContextRule(new String[]{"App.xml"}, test);

	@ClassRule
	public static TestRule mockRule = new MockRule(test);
	
	@Rule
	public TestRule dataSetupRule = new PojoSetupRule(this, new Customer());

	@Autowired
    public XMLConverter xmlConverter;

	@Mock
	public List baz;
	
	//can write our own annotation
	public Customer customer;

	@Test
	public void testObjectToXmlConversion() throws Exception {
		String xml = xmlConverter.convertFromObjectToXML(customer, null);
		System.out.println("**********"+xml);
		assertNotNull(xml);
	}

	/**
	 * sample test for mock rule
	 * @throws Exception
	 */
	@Test
	public void testListSize() throws Exception {
		when(baz.size()).thenReturn(2);
		assertEquals(2, baz.size());
	}


}
