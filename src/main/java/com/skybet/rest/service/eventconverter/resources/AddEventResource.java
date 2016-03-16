package com.skybet.rest.service.eventconverter.resources;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.skybet.rest.service.eventconverter.api.DecimalEventJSON;

@Path("/bets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddEventResource {


	@POST
	@Timed
	//check if you could declare that receive directly the DecimalEventJSON
	public DecimalEventJSON saveEvent( String decimalEvent ) throws JsonParseException, JsonMappingException, IOException {

//		ObjectMapper om = new ObjectMapper();
//		DecimalEventJSON de = om.readValue(decimalEvent, DecimalEventJSON.class); 
//
//		//    	  {         "bet_id": 1,      
//		//    		   "odds": 11.0,      
//		//    		   "stake": 10     } 
//		FractionalEventJSON fe = Utils.convertOddFromDecimalToFractional(de);
//
//
//		//TODO send fractional event to skybet and parse the result with mapper 
//
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
//		String output = response.getEntity(String.class);
//
//
//
//		//TODO call skybet platform and convert
//		return Utils.convertOddFromFractionalToDecimal(fe);
		return null;
	}


}


