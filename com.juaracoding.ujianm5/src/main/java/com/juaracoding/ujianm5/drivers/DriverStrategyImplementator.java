package com.juaracoding.ujianm5.drivers;

import com.juaracoding.ujianm5.utlis.Constants;

public class DriverStrategyImplementator {

	public static DriverStrategy chooseStrategy(String strategy){
        switch(strategy){
            case Constants.CHROME:
                return new Chrome();

            case Constants.FIREFOX:
                return new Firefox();

            default:
                return null;
        }

    }
}
