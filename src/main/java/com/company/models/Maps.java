package com.company.models;

import java.util.HashMap;
import java.util.LinkedList;
public class Maps {
	
	public static int numTurnedAway = 0;
	
	public static HashMap<String, LinkedList<Patient>> patientsInWard = new HashMap<String, LinkedList<Patient>>();
	public static HashMap<String, LinkedList<Patient>> waitingLists = new HashMap<String, LinkedList<Patient>>();
	
	public static void admitPatient(int wardID, Patient patient){
		
		switch (wardID){
		case 1:
			LinkedList<Patient> list = patientsInWard.get(wardID);
			if (list != null){
				if (list.size() <= 70){
					list.add(patient);
				} else {
					numTurnedAway++
				}
			} else {
				list = new LinkedList<Patient>();
				list.add(patient);
				patientsInWard.put(wardID, list);
			}
			break;
		case 2:
			LinkedList<Patient> list = patientsInWard.get(wardID);
			if (list != null){
				if (list.size() >= 30){
					LinkedList<Patient> waitingList = waitingLists.get(wardID);
					if (waitingList != null){
						waitingList.add(patient);
					} else {
						waitingList = new LinkedList<Patient>();
						waitingList.add(patient);
						waitingLists.put(wardID, waitingList);
					}
				} else {
					list.add(patient);
				}
			} else {
				list = new LinkedList<Patient>();
				list.add(patient);
				patientsInWard.put(wardID, list);
			}
			break;
		case 3:
			LinkedList<Patient> list = patientsInWard.get(wardID);
			if (list != null){
				if (list.size() >= 100){
					LinkedList<Patient> waitingList = waitingLists.get(wardID);
					if (waitingList != null){
						waitingList.add(patient);
					} else {
						waitingList = new LinkedList<Patient>();
						waitingList.add(patient);
						waitingLists.put(wardID, waitingList);
					}
				} else {
					list.add(patient);
				}
			} else {
				list = new LinkedList<Patient>();
				list.add(patient);
				patientsInWard.put(wardID, list);
			}
			break;
			
		case 4:
			LinkedList<Patient> list = patientsInWard.get(wardID);
			if (list != null){
				if (list.size() >= 40){
					LinkedList<Patient> waitingList = waitingLists.get(wardID);
					if (waitingList != null){
						waitingList.add(patient);
					} else {
						waitingList = new LinkedList<Patient>();
						waitingList.add(patient);
						waitingLists.put(wardID, waitingList);
					}
				} else {
					list.add(patient);
				}
			} else {
				list = new LinkedList<Patient>();
				list.add(patient);
				patientsInWard.put(wardID, list);
			}
			break;
			
		case 5:
			LinkedList<Patient> list = patientsInWard.get(wardID);
			if (list != null){
				if (list.size() >= 30){
					LinkedList<Patient> waitingList = waitingLists.get(wardID);
					if (waitingList != null){
						waitingList.add(patient);
					} else {
						waitingList = new LinkedList<Patient>();
						waitingList.add(patient);
						waitingLists.put(wardID, waitingList);
					}
				} else {
					list.add(patient);
				}
			} else {
				list = new LinkedList<Patient>();
				list.add(patient);
				patientsInWard.put(wardID, list);
			}
			break;
			
		case 6:
			LinkedList<Patient> list = patientsInWard.get(wardID);
			if (list != null){
				if (list.size() >= 40){
					LinkedList<Patient> waitingList = waitingLists.get(wardID);
					if (waitingList != null){
						waitingList.add(patient);
					} else {
						waitingList = new LinkedList<Patient>();
						waitingList.add(patient);
						waitingLists.put(wardID, waitingList);
					}
				} else {
					list.add(patient);
				}
			} else {
				list = new LinkedList<Patient>();
				list.add(patient);
				patientsInWard.put(wardID, list);
			}
			break;
			
		case 7:
			LinkedList<Patient> list = patientsInWard.get(wardID);
			if (list != null){
				if (list.size() >= 10){
					LinkedList<Patient> waitingList = waitingLists.get(wardID);
					if (waitingList != null){
						waitingList.add(patient);
					} else {
						waitingList = new LinkedList<Patient>();
						waitingList.add(patient);
						waitingLists.put(wardID, waitingList);
					}
				} else {
					list.add(patient);
				}
			} else {
				list = new LinkedList<Patient>();
				list.add(patient);
				patientsInWard.put(wardID, list);
			}
			break;
		}
	}
	
	public static void movePatient(int fromWard, int toWard, int patientID){
		
	}
}
