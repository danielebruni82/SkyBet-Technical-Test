package com.skybet.oddConverter;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.skybet.rest.service.eventconverter.api.DecimalEventJSON;
import com.skybet.rest.service.eventconverter.api.ExtendedDecimalEventJSON;
import com.skybet.rest.service.eventconverter.api.FractionalEventJSON;
import com.skybet.rest.service.eventconverter.resources.AddEventResource;
import com.skybet.rest.service.eventconverter.resources.AvailableEventsResource;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RemoteServiceTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public RemoteServiceTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( RemoteServiceTest.class );
	}

	/**
	 * Rigourous Test :-)
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public void testApp() throws JsonParseException, JsonMappingException, IOException
	{
		shouldSaveEvent();
		shouldGetAvailableEvents();

	}

	private void shouldSaveEvent() throws JsonParseException, JsonMappingException, IOException {
		//given
		ExtendedDecimalEventJSON helper = decimalEventHelper();
		AddEventResource aer = new AddEventResource();
		//when
		Object obj = aer.saveEvent(helper);
		//then
		assertNotNull(obj);
		assertNotNull(((ExtendedDecimalEventJSON)obj).getEvent());
		assertNotNull(((ExtendedDecimalEventJSON)obj).getName());
		assertNotNull(((ExtendedDecimalEventJSON)obj).getBet_id());
		assertNotNull(((ExtendedDecimalEventJSON)obj).getOdds());
		assertNotNull(((ExtendedDecimalEventJSON)obj).getStake());
		assertNotNull(((ExtendedDecimalEventJSON)obj).getTransaction_id());
	}
	
	private void shouldGetAvailableEvents() throws JsonParseException, JsonMappingException, IOException {
		//given
		AvailableEventsResource aer = new AvailableEventsResource();
		//when
		Object obj = aer.getAvailableEvents();
		//then
		assertNotNull(obj);
		for (DecimalEventJSON decimalEventJSON : (List<DecimalEventJSON>)obj) {
			assertNotNull(decimalEventJSON.getEvent());
			assertNotNull(decimalEventJSON.getName());
			assertNotNull(decimalEventJSON.getBet_id());
			assertNotNull(decimalEventJSON.getOdds());
		}

	}
	
	

	private ExtendedDecimalEventJSON decimalEventHelper() {
		ExtendedDecimalEventJSON deHelper = new ExtendedDecimalEventJSON();

		deHelper.setBet_id(1);
		deHelper.setOdds(11);
		deHelper.setStake(10);
		return deHelper;

	}
}
