package com.api.util;

import java.util.HashMap;
import java.util.Map;

public class SymptomSpeciality 
{
   public static Map<String,String> map=new HashMap<>();
   static {
	   map.put("Arthritis", "orthopedic");
	   map.put("Backpain", "orthopedic");
	   map.put("Tissu injuries", "orthopedic");
	   map.put("Dysmenorrhea", "gynecology");
	   map.put("Skin infection", "Dermatology");
	   map.put("skin burn", "Dermatology");
	   map.put("Ear pain", "ENT");
	   map.put("Throat sore", "ENT");
   }
}
