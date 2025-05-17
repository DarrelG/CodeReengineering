package carstore;
/*
Authors:  All Group
partener and correction : the leader of team Wafaa Elsaeed
date : during studing at firstTerm and mid trem vacation
Summary of  Car Store App:
1- test all classes and recat with customer with buy method 
*/


/*
 * Code Smell 	: Large Class
 * Reason		: Class ini menampung banyak metode seperti generateVihicle dan generateStaff yang harusnya merupakan class sendiri
 * Solution		: Ekstrak Class
 * 
 * Code Smell	: Long Method
 * Reson		: Method main menghandle banyak sekali tugas
 * Solution		: Extract Class
 * 
 * Code Smell	: Comments
 * Reason		: Banyak komentar yang tidak terlalu penting
 * Solution		: Hapus komentar
 */


import java.util.Scanner;
public class CarStoreApp {
	
	public static void main(String[] args) {

		CarStore Shop = new CarStore ("The Car Store","2520 N Salisbury Blvd", "(410) 334-3500","http://thecarstoreonline.com/", 0);
		System.out.print(Shop.toString() +"\n");
		printline();
		
		insertCar(Shop);
          
		Shop.showInventory();
        printline();
        
        insertStaff(Shop);
        
        Shop.showStaffDetails();
		printline() ;
       
        insertCustomer(Shop);
        
        Shop.showCustomersDetails();
        printline();
        
        System.out.println(Shop.searseCar(6).toString());
        printline();
             
        System.out.print(BuyCar.buyCar(Shop));
        printline();

      
        System.out.println("test of search and delete of customer ,staff and cars ");
        Scanner g = new Scanner(System.in);
      
        System.out.println("Entr Id of items u want to delet or search " );
        int ID = g.nextInt();
      
        System.out.println(Shop.searseCustomer(ID).toString());
        printline() ;

        System.out.println(Shop.searseStaff(ID).toString());
        printline() ;

        Shop.deleteEmpoyee(ID);
       
        Shop.deleteCar(ID);
      
        Shop.deleteCustomer(ID);
      }
	
	
	private static void insertCar(CarStore Shop) {
		for(int i =1 ; i<=10 ;i++){
            
	        Vehicle mac  = new NewCar(GenerateRandom.randomModel(GenerateRandom.randomMake()), GenerateRandom.randomMake(), GenerateRandom.randomCountry(),
	        		GenerateRandom.randomColour(),  GenerateRandom.randomFuelType(), i, GenerateRandom.randomNumber(300,150), GenerateRandom.randomNumber(15,9), GenerateRandom.randomNumber(50000,17000), 
	        		GenerateRandom.randomNumber(2017,1995), GenerateRandom.randomBoolean(),GenerateRandom.randomBoolean(),GenerateRandom.randomBoolean(),GenerateRandom.randomBoolean());
	        
	        Shop.insertCar(mac);}
	}
	
	private static void insertStaff(CarStore Shop) {
		for(int i =1 ; i<=9 ;i++){
	        
        	Staff s = new Staff(GenerateRandom.randomName(), GenerateRandom.randomCountry(), GenerateRandom.randomNumber(23432525,23456721)+"",
        			"employee"+i+"@carStore.com", i, GenerateRandom.randomPosition(), GenerateRandom.randomNumber(25532,20000), GenerateRandom.randomNumber(7000,3000));
        	Shop.insertEmployee(s);
        	
        }
	}
	
	private static void insertCustomer(CarStore Shop) {
		 for(int i =1 ; i<=9 ;i++){
	        	Customer c = new Customer(GenerateRandom.randomName(), GenerateRandom.randomCountry(), GenerateRandom.randomNumber(23432525,23456721) + "",
	        			"customer000" + i + "@gmail.com", i);
	        	
	        	Shop.insertCustomer(c);
		 }
	}
    
	public  static void printline(){
		System.out.println("\n---------------------------------------------------" + "--------------------------------------------" + "-------------------------------------------------------------------------------------------------\n");
	}
}
