package carstore;

/*
Authors:   All Group
partener and correction : the leader of team Wafaa Elsaeed
date : during studing at firstTerm and mid trem vacation
Summary of CarStore :
1- represent details of Car store 
2- has some motheds that make buying process easy  
*/

/*
 * Code Smell	: Comments
 * Reason		: Banyak komentar yang tidak perlu
 * Solution		: Hapus Komentar
 * 
 * Code Smell	: Speculative Generality
 * Reason		: Method searchBy tidak digunakam dimanapun
 * Solution		: Hapus method yang tidak perlu
 */

import java.util.HashMap;

public class CarStore extends ProfileData{
     
	private static final int YEAROFSET =1995;
    private static final  String DESCRIPTION = "We love Cars--We love People.. Come experience The Car Store difference.";
    
    private HashMap <Integer,Staff> staff = new HashMap<>() ;
    private HashMap<Integer, Profile> customers = new HashMap<>();
    protected static HashMap <Integer,Vehicle> inventory = new HashMap<>() ;

    public CarStore (String name, String address, String contactNumber, String website, int ID) {
        super(name, address, contactNumber, website, ID);
    }

    
    public void insertEmployee(Staff employee){
    	staff.put(employee.getId(), employee);
    }
   
    public Staff searseStaff(int id){
    	return staff.get(id);
    }
    
    
    public void deleteEmpoyee(int id){
    	staff.remove(id);
    }
    
   public void insertCustomer(Profile customer){
      customers.put(customer.getId(), customer);
  }

  public Profile searseCustomer(int id){
      return customers.get(id);
  }

    public void deleteCustomer(int id){
    	customers.remove(id);
    }
    
   public void insertCar( Vehicle car){
	   	inventory.put(car.getID(), car);
   }
   
   public Vehicle searseCar(int id){
	   return inventory.get(id);
   }
    
   public void deleteCar(int id){
	   inventory.remove(id);
   }
   
    public int getyearOfset(){
        return YEAROFSET;
    }
  
    public String getdescription(){
    	return DESCRIPTION;
    }
    
    public void searchByModel(String model){
    	HashMap <Integer,Vehicle> search = new HashMap<>();
    	for (int key :inventory.keySet()){
    		if(inventory.get(key).getModel().equalsIgnoreCase(model)){
    			search.put(key,inventory.get(key) );
    		}
    	}
    	for (int key :search.keySet()){
    		System.out.println(search.get(key).toString());
    	}  
    }

    @Override
    public String toString(){
    	return  "name          : " + getName() +
    			"\ndescribion    : "+ DESCRIPTION
    			+"\nYearofSet     : " +YEAROFSET
    			+ "\nwebsite       : "
    			+getEmail()+
    			"\naddress       : "+getAddress()+
    			" \nContactNumber : "+getContactNumber();
    }

    @Override
    public ProfileData clone(){
    	CarStore C = new CarStore(getName(),  getAddress(),  getContactNumber(),  getEmail(), getID() );
        return C;
    }

    @Override
    public boolean equals(Object O){
    	CarStore c =(CarStore)O;
        
    	return super.equals(O)&& c.getdescription().equals(DESCRIPTION) && c.getyearOfset() == YEAROFSET;
    }

    public void showInventory(){
    	System.out.println("model \t\t\t make  \t madeIn  \tcolour  FuelType  \tYearIntroduced       "   
                + "\tspeed \t id"
                + "\tpower \t price"
                + "\n");
    	
    	for (int key :inventory.keySet()){
    		System.out.println(inventory.get(key).showDetetails());
    	}  
    }
 
    public void showStaffDetails(){
    	System.out.println("Name\t Address     \t Contact Number            E-mail                  id        "
                + "        Position    "
                + "                saraly      retire       ");
    	
    	for (int key :staff.keySet()){
    		System.out.println(staff.get(key).toString());
    	}  
    }
  
    public void showCustomersDetails(){
		System.out.println("Name\t Address     \t Contact Number            E-mail                  id "  );
		
    	 for (int key :customers.keySet()){
        System.out.println(customers.get(key).toString());
    }  
}
}

