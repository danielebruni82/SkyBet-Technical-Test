package com.skybet.rest.service.eventconverter.application;

import com.skybet.rest.service.eventconverter.config.OddConverterConfiguration;
import com.skybet.rest.service.eventconverter.resources.AvailableEventsResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class OddConverterApplication extends Application<OddConverterConfiguration> {
	public static void main(String[] args) throws Exception {
		new OddConverterApplication().run(args);
	}



	@Override
	public void initialize(Bootstrap<OddConverterConfiguration> bootstrap) {
		// nothing to do yet
	}



	@Override
	public void run(OddConverterConfiguration configuration,Environment environment) {
		final AvailableEventsResource resource = new AvailableEventsResource();
		environment.jersey().register(resource);
	}

}