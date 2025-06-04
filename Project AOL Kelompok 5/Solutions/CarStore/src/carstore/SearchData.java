package carstore;

import java.util.HashMap;

public class SearchData{

	public static void searchByModel(String model){
	    	HashMap <Integer,Vehicle> search = new HashMap<>();
	    	for (int key : CarStore.inventory.keySet()){
	    		if(CarStore.inventory.get(key).getModel().equalsIgnoreCase(model)){
	    			search.put(key, CarStore.inventory.get(key));
	    		}
	    	}
	    	for (int key :search.keySet()){
	    		System.out.println(search.get(key).toString());
	    	}  
	    }
	
	 public static void searchByMake(String make){
		 HashMap <Integer,Vehicle> search = new HashMap<>();
		 for (int key : CarStore.inventory.keySet()){
			 if(CarStore.inventory.get(key).getMake().equalsIgnoreCase(make)){
				 search.put(key, CarStore.inventory.get(key) );
			 }
		 }
		 for (int key :search.keySet()){
			 System.out.println(search.get(key).toString());
		 }  
	 }
	 
	 public static void searchByPrice(double from ,double to ){
	       HashMap <Integer,Vehicle> search = new HashMap<>();
	       for (int key : CarStore.inventory.keySet()){
	    	   if(CarStore.inventory.get(key).getPrice()>=from && CarStore.inventory.get(key).getPrice()<=to ){
	    		   search.put(key, CarStore.inventory.get(key) );
	    	   }
	       }
	       for (int key :search.keySet()){
	    	   System.out.println(search.get(key).toString());
	       }  
	 }
}
