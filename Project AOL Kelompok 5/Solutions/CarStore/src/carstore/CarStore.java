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

public class CarStore extends Profile {
     
	private static final int YEAROFSET =1995;
    private static final  String DESCRIPTION = "We love Cars--We love People.. Come experience The Car Store difference.";
    
    private  HashMap <Integer,Staff> staff = new HashMap<>() ;
     private HashMap<Integer, Profile> customers = new HashMap<>();
    private  HashMap <Integer,Vehicle> inventory = new HashMap<>() ;

    public CarStore (ProfileData data) {
    	super(data);
    }

    
    public void insertEmployee(Staff employee){
    	staff.put(employee.getId(), employee);
    }
   
    public Staff searseStaff(int ID){
    	return staff.get(ID);
    }
    
    
    public void deleteEmpoyee(int ID){
    	staff.remove(ID);
    }
    
   public void insertCustomer(Profile customer){
      customers.put(customer.getId(), customer);
  }

  public Profile searseCustomer(int ID){
      return customers.get(ID);
  }

    public void deleteCustomer(int ID){
    	customers.remove(ID);
    }
    
   public void insertCar( Vehicle car){
	   	inventory.put(car.getID(), car);
   }
   
   public Vehicle searseCar(int ID){
	   return inventory.get(ID);
   }
    
   public void deleteCar(int ID){
	   inventory.remove(ID);
   }
   
    public int getyearOfset(){
        return YEAROFSET;
    }
  
    public String getdescription(){
    	return DESCRIPTION;
    }

    @Override
    public String toString(){
        return  "name          : " + getName() +
                "\ndescribion    : "+ DESCRIPTION
                +"\nYearofSet     : " +YEAROFSET
                + "\nwebsite       : "
                + getEmail() +
                "\naddress       : " + getAddress() +
                " \nContactNumber : " + getContactNumber();
    }

    @Override
    public Profile clone(){
        ProfileData carStoreData = new ProfileData(
                getName(),
                getAddress(),
                getContactNumber(),
                getEmail(),
                getId());
    	CarStore carStore = new CarStore(carStoreData);
        return carStore;
    }

    @Override
    public boolean equals(Object O){
    	CarStore c =(CarStore)O;
        
    	return super.equals(O)&& c.getdescription().equals(DESCRIPTION) && c.getyearOfset() == YEAROFSET;
    }

    public void showInventory(){
    	System.out.println("model \t\t\t make  \t madeIn  \tcolour  FuelType  \tYearIntroduced       "   
                + "\tspeed \t ID"
                + "\tpower \t price"
                + "\n");
    	
    	for (int key :inventory.keySet()){
    		System.out.println(inventory.get(key).showDetetails());
    	}  
    }
 
    public void showStaffDetails(){
    	System.out.println("Name\t Address     \t Contact Number            E-mail                  ID        "
                + "        Position    "
                + "                saraly      retire       ");
    	
    	for (int key :staff.keySet()){
    		System.out.println(staff.get(key).toString());
    	}  
    }
  
    public void showCustomersDetails(){
		System.out.println("Name\t Address     \t Contact Number            E-mail                  ID "  );
		
    	 for (int key :customers.keySet()){
        System.out.println(customers.get(key).toString());
    }  
}
}

