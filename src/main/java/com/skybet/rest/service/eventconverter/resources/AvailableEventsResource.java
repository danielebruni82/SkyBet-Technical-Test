package com.skybet.rest.service.eventconverter.resources;

import static com.skybet.rest.service.eventconverter.application.OddConverterApplication.SKYBET_SERVICE;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.codahale.metrics.annotation.Timed;
import com.skybet.rest.service.eventconverter.api.DecimalEventJSON;
import com.skybet.rest.service.eventconverter.api.FractionalEventJSON;
import com.skybet.rest.service.eventconverter.utils.Utils;

@Path("/available")
@Produces(MediaType.APPLICATION_JSON)
public class AvailableEventsResource {

	private static String ACTION = "/available";

	@GET
	@Timed
	public Object getAvailableEvents() {

		List<DecimalEventJSON> returnValue = new ArrayList<DecimalEventJSON>();

		try {
			for (FractionalEventJSON fractionalEventJSON : getAvailableEventsFromSkybetService()) {
				returnValue.add(Utils.convertOddFromFractionalToDecimal(fractionalEventJSON));
			}

			return returnValue;
		}
		catch (RuntimeException ex) {
			return ex.getMessage();
		}	
	}


	private List<FractionalEventJSON> getAvailableEventsFromSkybetService() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(SKYBET_SERVICE + ACTION);

		Response response = target.request().get();
		if (response.getStatus() != 200)
			throw new RuntimeException(response.readEntity(String.class));

		return response.readEntity(new GenericType<List<FractionalEventJSON>>(){});
	}

}


