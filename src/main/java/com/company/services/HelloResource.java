package com.company.services;

import javax.ws.rs.DefaultValue;

import org.springframework.context.PayloadApplicationEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.company.models.Maps;
import com.company.models.Patient;
import com.company.models.ReadInput;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        ReadInput.getWardsList();
        
    	return "Hello " + name;
    }

	@Override
	public ResponseEntity getMap() {
		// TODO Auto-generated method stub
		HashMap<Integer, LinkedList<Patient>> patientsList = new HashMap<Integer, LinkedList<Patient>>();
		//patientsList = Maps.patientsInWard;
		
		LinkedList<Patient> patientsLinkedlist = new LinkedList<Patient>();
		Patient p = new Patient(1, "abc", "25/09/2015", 1);
		patientsLinkedlist.add(p);
		
		
		patientsList.put(1, patientsLinkedlist);
		
		return new ResponseEntity(patientsList, HttpStatus.OK);
		
		
	}
}
