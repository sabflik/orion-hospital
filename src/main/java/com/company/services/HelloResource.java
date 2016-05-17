package com.company.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DefaultValue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        ReadInput.getPatientsList();
        ReadInput.getMovementsList();
        
    	return "Hello " + name;
    }

	@Override
	public ResponseEntity getMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "test");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
    

}
