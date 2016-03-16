package com.skybet.rest.service.eventconverter.utils;


import com.skybet.rest.service.eventconverter.api.DecimalEventJSON;
import com.skybet.rest.service.eventconverter.api.FractionalEventJSON;


public class Utils {

    public static FractionalEventJSON convertOddFromDecimalToFractional(DecimalEventJSON de) {
		return null;
    	
    }
    
    public static DecimalEventJSON convertOddFromFractionalToDecimal(FractionalEventJSON fe) {
		return null;
    	
    }

    
//    public static void main(String[] args) {
//    	try {
//
//    		Client client = Client.create();
//
//    		WebResource webResource = client
//    		   .resource("http://skybettechtestapi.herokuapp.com/available");
//
//    		ClientResponse response = webResource.accept("application/json")
//                       .get(ClientResponse.class);
//
//    		if (response.getStatus() != 200) {
//    		   throw new RuntimeException("Failed : HTTP error code : "
//    			+ response.getStatus());
//    		}
//
//    		String output = response.getEntity(String.class);
//
//    		System.out.println("Output from Server .... \n");
//    		System.out.println(output);
//
//    	  } catch (Exception e) {
//
//    		e.printStackTrace();
//
//    	  }
//
//    	}
}
