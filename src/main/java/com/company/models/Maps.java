package com.company.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
public class Maps {
	
	public static int numTurnedAway = 0;
	public static int numDeaths = 0;
	public static LinkedList<Patient> deadList = new LinkedList<Patient>();
	
	public static LinkedList<Patient> patientList = ReadInput.getPatientsList();
	public static ArrayList<Ward> wardList = ReadInput.getWardsList();
	public static ArrayList<Movement> movementList = ReadInput.getMovementsList();
	
	public static HashMap<Integer, LinkedList<Patient>> patientsInWard = new HashMap<Integer, LinkedList<Patient>>();
	public static HashMap<Integer, LinkedList<Patient>> waitingLists = new HashMap<Integer, LinkedList<Patient>>();
	
	
	public static void buildMaps(){
		for (int i = 1; i < 8; i++){
			patientsInWard.put(i, new LinkedList<Patient>());
			
		}
		for (int i = 3; i < 8; i++){
			waitingLists.put(i, new LinkedList<Patient>());
		}
	}
	public static void main(String[] args) {
		
//		System.out.println("hi");
//		System.out.println(patientList.get(1).getName());
//		for (Patient p: patientList) {
//			System.out.println(p.getName());
//		}
		
		buildMaps();
		
		for (int i = 0; i< 10000; i++) {
			Movement m = movementList.get(i);
			if (m.getFrom_ward().equals("admitting")) {
				admitPatient(Integer.parseInt(m.getTo_ward()), patientList.get(m.getId()));
			} else if (m.getTo_ward().equals("discharging")) {
				dischargePatient(patientList.get(m.getId()));
			
			}else {
				movePatient(Integer.parseInt(m.getFrom_ward()), Integer.parseInt(m.getTo_ward()),patientList.get(m.getId()));
			}
		}
		for (int i : patientsInWard.keySet()){
			for (Patient p: patientsInWard.get(i)) {
				System.out.println(i + " " + p.getName());
			}
		}
		System.out.println("number of deaths is:" + numDeaths);
	}
	public static boolean admitPatient(int wardID, Patient patient){
		boolean moved = false;
		LinkedList<Patient> list = patientsInWard.get(wardID);
		switch (wardID){
		case 1:
				if (list.size() < 70){
					list.add(patient);
					patient.setCurrentWard(1);
					moved = true;
				} else {
					numTurnedAway++;
				}
			
			break;
		case 2:

				if (list.size() < 30){
					list.add(patient);
					patient.setCurrentWard(2);
					moved = true;
				} else {
					numDeaths++;
					deadList.add(patient);
				}
			
			
			break;
		case 3:
				if (list.size() >= 100){
					LinkedList<Patient> waitingList = waitingLists.get(wardID);
					if (waitingList != null){
						waitingList.add(patient);
						patient.setWaitingWard(3);
					} else {
						waitingList = new LinkedList<Patient>();
						waitingList.add(patient);
						patient.setWaitingWard(3);
						waitingLists.put(wardID, waitingList);
					}
				} else {
					list.add(patient);
					patient.setCurrentWard(3);
					moved = true;
				}
			
			break;
			
		case 4:
				if (list.size() >= 40){
					LinkedList<Patient> waitingList = waitingLists.get(wardID);
					if (waitingList != null){
						waitingList.add(patient);
						patient.setWaitingWard(4);
					} else {
						waitingList = new LinkedList<Patient>();
						waitingList.add(patient);
						patient.setWaitingWard(4);
						waitingLists.put(wardID, waitingList);
					}
				} else {
					list.add(patient);
					patient.setCurrentWard(4);
					moved = true;
				}
			
				
			break;
			
		case 5:

				if (list.size() >= 30){
					LinkedList<Patient> waitingList = waitingLists.get(wardID);
					if (waitingList != null){
						waitingList.add(patient);
						patient.setWaitingWard(5);
					} else {
						waitingList = new LinkedList<Patient>();
						waitingList.add(patient);
						patient.setWaitingWard(5);
						waitingLists.put(wardID, waitingList);
					}
				} else {
					list.add(patient);
					patient.setCurrentWard(5);
					moved = true;
				}
			
			break;
			
		case 6:
				if (list.size() >= 40){
					LinkedList<Patient> waitingList = waitingLists.get(wardID);
					if (waitingList != null){
						waitingList.add(patient);
						patient.setWaitingWard(6);
					} else {
						waitingList = new LinkedList<Patient>();
						waitingList.add(patient);
						patient.setWaitingWard(6);
						waitingLists.put(wardID, waitingList);
					}
				} else {
					list.add(patient);
					patient.setCurrentWard(6);
					moved = true;
				}
			
			break;
			
		case 7:
				if (list.size() >= 10){
					LinkedList<Patient> waitingList = waitingLists.get(wardID);
					if (waitingList != null){
						waitingList.add(patient);
						patient.setWaitingWard(7);
					} else {
						waitingList = new LinkedList<Patient>();
						waitingList.add(patient);
						patient.setWaitingWard(7);
						waitingLists.put(wardID, waitingList);
					}
				} else {
					list.add(patient);
					patient.setCurrentWard(7);
					moved = true;
				}
			
			break;
		}
		return moved;
	}
	
	public static void movePatient(int fromWard, int toWard, Patient patientID){
		if (admitPatient(toWard, patientID)) {
			patientsInWard.get(fromWard).remove(patientID);
			//allowPatient(fromWard);
//			if (waitingLists.get(toWard).contains(patientID)) {
//				waitingLists.get(toWard).remove(patientID);
//			}
			patientID.setCurrentWard(toWard);
			patientID.setWaitingWard(0);
		}
	}
	
	public static void dischargePatient(Patient patient){
		
		patientsInWard.get(patient.getCurrentWard()).remove(patient);
		if (patient.getWaitingWard()!=0){
			if (waitingLists.get(patient.getWaitingWard()).contains(patient.getId())) {
				waitingLists.get(patient.getWaitingWard()).remove(patient.getId());
			}
		}
		allowPatient(patient.getCurrentWard());
		
	}
	
	public static void allowPatient(int freedWard) {
//		
//		if (!waitingLists.get(freedWard).isEmpty()) {
//			Patient p = waitingLists.get(freedWard).getFirst();
//			
//			
//			
//			movePatient(p.getCurrentWard(), freedWard, p);
//		}
	
	}
}
