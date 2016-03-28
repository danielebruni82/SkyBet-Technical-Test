package com.skybet.rest.service.eventconverter.utils;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

import com.skybet.rest.service.eventconverter.api.DecimalEventJSON;
import com.skybet.rest.service.eventconverter.api.ExtendedDecimalEventJSON;
import com.skybet.rest.service.eventconverter.api.FractionalEventJSON;
import com.skybet.rest.service.eventconverter.api.FractionalOdd;


public class Utils {

	public static FractionalEventJSON convertOddFromDecimalToFractional(ExtendedDecimalEventJSON de) {
		FractionalEventJSON returnValue = new FractionalEventJSON();
		returnValue.setBet_id(de.getBet_id());
		returnValue.setOdds(decimalToFractional(de.getOdds()));
		returnValue.setStake(de.getStake());
		return returnValue;

	}

	public static DecimalEventJSON convertOddFromFractionalToDecimal(FractionalEventJSON fe) {
		DecimalEventJSON returnValue =  new DecimalEventJSON();
		returnValue.setBet_id(fe.getBet_id());
		returnValue.setEvent(fe.getEvent());
		returnValue.setName(fe.getName());
		returnValue.setOdds(fractionalToDecimal(fe.getOdds().getNumerator(), fe.getOdds().getDenominator())) ;
		return returnValue;

	}

	public static ExtendedDecimalEventJSON convertOddFromFractionalToExtendedDecimal( FractionalEventJSON fe) {
		ExtendedDecimalEventJSON returnValue =  new ExtendedDecimalEventJSON();
		returnValue.setBet_id(fe.getBet_id());
		returnValue.setEvent(fe.getEvent());
		returnValue.setName(fe.getName());
		returnValue.setOdds(fractionalToDecimal(fe.getOdds().getNumerator(), fe.getOdds().getDenominator())) ;
		returnValue.setStake(fe.getStake());
		returnValue.setTransaction_id(fe.getTransaction_id());
		return returnValue;

	}

	private static double fractionalToDecimal(double num, double den) {

		double val = num / den;
		val = Math.round(val * 100.0) / 100.0;
		val = val + 1;
		DecimalFormat df = new DecimalFormat("#.00");
		String value  = df.format(val);
		return Double.parseDouble(value);
	}

    private static int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }

    private static FractionalOdd decimalToFractional(double odd) {
    	FractionalOdd fo = new FractionalOdd();
    	BigDecimal bd = new BigDecimal(String.valueOf(odd));
    	odd = Double.parseDouble(String.valueOf(bd.subtract(new BigDecimal(1))));
        String s = String.valueOf(odd);
        int digitsDec = s.length() - 1 - s.indexOf('.');
        int denom = 1;
        for (int i = 0; i < digitsDec; i++) {
        	odd *= 10;    
            denom *= 10;
        }

        int num = (int) Math.round(odd);
        int g = gcd(num, denom);
        num = num / g;
        denom = denom /g;
        fo.setNumerator(num);
        fo.setDenominator(denom);
        return fo;
    }
    
}
