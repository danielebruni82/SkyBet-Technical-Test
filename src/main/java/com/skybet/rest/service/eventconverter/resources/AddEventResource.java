package com.skybet.rest.service.eventconverter.resources;

import static com.skybet.rest.service.eventconverter.application.OddConverterApplication.SKYBET_SERVICE;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.skybet.rest.service.eventconverter.api.ExtendedDecimalEventJSON;
import com.skybet.rest.service.eventconverter.api.FractionalEventJSON;
import com.skybet.rest.service.eventconverter.utils.Utils;

@Path("/bets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddEventResource {

	private static String ACTION = "/bets";

	@POST
	@Timed
	public Object saveEvent( ExtendedDecimalEventJSON de ) throws JsonParseException, JsonMappingException, IOException {
		FractionalEventJSON fe = Utils.convertOddFromDecimalToFractional(de);

		try {
			FractionalEventJSON response = postBetToSkybetService(fe);
			return Utils.convertOddFromFractionalToExtendedDecimal(response);
		}
		catch (RuntimeException ex) {
			return ex.getMessage();
		}

	}

	private FractionalEventJSON postBetToSkybetService(FractionalEventJSON fe) throws JsonGenerationException, JsonMappingException, IOException {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(SKYBET_SERVICE + ACTION);
		Response response = target.request().post(Entity.json(fe));

		if (response.getStatus() != 201)
			throw new RuntimeException(response.readEntity(String.class));

		return response.readEntity(FractionalEventJSON.class);
	}


}


