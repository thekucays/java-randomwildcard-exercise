package com.luki.tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.luki.pojos.User;
import com.luki.pojos.User.Gender;
import com.luki.pojos.User.Status;

public class MapIterationTest {
	// as usual, a singleton pattern for the sake of memory efficiency lol
	private static MapIterationTest getInstance(){
		return new MapIterationTest();
	}
	
	public static void main(String[] args){
		// create active user
		User luki = new User();
		luki.setNama("luki");
		luki.setGender(Gender.MALE);
		luki.setStatus(Status.ACTIVE);
		
		// create pending user
		User antar = new User();
		antar.setNama("antar");
		antar.setGender(Gender.MALE);
		antar.setStatus(Status.PENDING);
		
		// never created user
		User laras = new User();
		laras.setNama("laras");
		laras.setGender(Gender.FEMALE);
		laras.setStatus(Status.NEVER_CREATED);
		
		// blocked user
		User cika = new User();
		cika.setNama("cika");
		cika.setGender(Gender.UNSPECIFIED);
		cika.setStatus(Status.BLOCKED);

		// add users to map in order to iterate it
		Map<String, User> mapUser = new HashMap<String, User>();
		mapUser.put("luki", luki);
		mapUser.put("antar", antar);
		mapUser.put("laras", laras);
		mapUser.put("cika", cika);
		
		for(Map.Entry<String, User>entry : mapUser.entrySet()){
			System.out.println("-------");
			System.out.println(entry.getKey());
			//System.out.println(((User)entry.getValue()).getGender());
			User temp = MapIterationTest.getInstance().checkIfValid(entry.getValue()) == null ? null : entry.getValue();  // ternary if lol
			
			if(temp != null){
				System.out.println("User " + temp.getNama() + " valid!");
				System.out.println("status : " + temp.getStatus());
				System.out.println("generation allowed? : " + temp.getStatus().isGenerationAllowed());
				System.out.print("gender allowed : ");
				System.out.println(temp.getGender().isGenderAllowed() ?  "yes" :  "no");
			}
			
			System.out.println("-------");
		}
	}
	
	private User checkIfValid(User user){
		if(user instanceof User){
			return user;
		}
		else{
			return null;
		}
	}
}
