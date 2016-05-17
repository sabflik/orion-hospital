package com.company.services;

import javax.ws.rs.DefaultValue;

import com.company.models.ReadInput;

/**
 * @author Chang Kon Han
 * @author John Law
 * @author Wesley Yep
 * @since 23 Feb 2016
 */
public class HelloResource implements IHelloResource {
    @Override
    public String hello(@DefaultValue("World!") String name) {
//        ReadInput.getPatientsList();
//        ReadInput.getMovementsList();
        
    	return "Hello " + name;
    }
}
