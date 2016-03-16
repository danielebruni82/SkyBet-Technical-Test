package com.skybet.rest.service.eventconverter.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.skybet.rest.service.eventconverter.api.DecimalEventJSON;

@Path("/available")
@Produces(MediaType.APPLICATION_JSON)
public class AvailableEventsResource {


	@GET
	@Timed
	public List<DecimalEventJSON> getAvailableEvents() {



//		//get from skybet
//		Client client = Client.create();
//
//		WebResource webResource = client.resource("http://skybettechtestapi.herokuapp.com/available");
//
//		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
//
//		if (response.getStatus() != 200) {
//			throw new RuntimeException("Failed : HTTP error code : "
//					+ response.getStatus());
//		}
//
//		List<FractionalEventJSON> fractionaEvents = (List<FractionalEventJSON>) response.getEntity(FractionalEventJSON.class);
//
//		ArrayList<DecimalEventJSON> decimalEvents = new ArrayList<DecimalEventJSON>();
//
//		for (FractionalEventJSON fractionalEventJSON : fractionaEvents) {
//			decimalEvents.add( Utils.convertOddFromFractionalToDecimal(fractionalEventJSON));
//			System.out.println(Utils.convertOddFromFractionalToDecimal(fractionalEventJSON));
//		}
//
//		return decimalEvents;
		return null;
	}

	@POST
	@Timed
	public String sayHello() {
		//TODO call skybet platform and convert
		return "ciao Kikko!!";
	}


}


