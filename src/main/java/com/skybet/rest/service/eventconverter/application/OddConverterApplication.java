package com.skybet.rest.service.eventconverter.application;

import com.skybet.rest.service.eventconverter.config.OddConverterConfiguration;
import com.skybet.rest.service.eventconverter.resources.AddEventResource;
import com.skybet.rest.service.eventconverter.resources.AvailableEventsResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;



public class OddConverterApplication extends Application<OddConverterConfiguration> {

	public static String SKYBET_SERVICE = "http://skybettechtestapi.herokuapp.com";
	
	public static void main(String[] args)  {
		try {
			new OddConverterApplication().run(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(Bootstrap<OddConverterConfiguration> bootstrap) {
		// nothing to do yet
	}

	@Override
	public void run(OddConverterConfiguration configuration,Environment environment) {
		final AvailableEventsResource availableEventsResourceResouerce = new AvailableEventsResource();
		final AddEventResource addEventResourceResource = new AddEventResource();
		
		environment.jersey().register(availableEventsResourceResouerce);
		environment.jersey().register(addEventResourceResource);
		
	}

}