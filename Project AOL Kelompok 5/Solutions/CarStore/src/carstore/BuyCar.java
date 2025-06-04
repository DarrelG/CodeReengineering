package carstore;

import java.util.Scanner;

public class BuyCar {
	public static String buyCar(CarStore d){
   	 String result =null ;
   	 System.out.println("welcome  to The Car store :)\n "
   			 + "for veiw inventory enter 1 \n"
   			 + "for search by price enter 2 \n "
   			 + "for search by model enter 3 \n"
   			 + "for search by make entre  4 \n");
       
   	 Scanner s = new Scanner(System.in);
   	 int choise = s.nextInt();
       
   	 switch(choise){
           case 1: 
           	d.showInventory();
           	break;
           
           case 2: 
               System.out.println("Enter from and to price plz :)");
               double from= s.nextDouble() ;double to =s.nextDouble();
               SearchData.searchByPrice(from, to);
               break;
           
           case 3:               
               System.out.println("Enter model plz :)");
               String model =s.nextLine();
               SearchData.searchByModel(model);
               break;
               
           case 4:   
               System.out.println("Enter model plz :)");
               String make =s.nextLine();
               SearchData.searchByMake(make);
               break;
   	 }
       
   	 System.out.println("then is there any car u liked it :D plz enter 1 if u want to buy it entre any 0 if there dont");
       
   	 int choise2 = s.nextInt();
       
   	 if(choise2==1) { 
   		 System.out.println("then entre it ID ");
           
   		 int ID = s.nextInt();
           
   		 Vehicle car =d.searseCar(ID);
   		 System.out.print("here is it all details  ");
   		 System.out.println( car.toString());
   		 System.out.print( "sure u want it then go to fainlize put it price");
           
   		 double price = s.nextDouble();

           while(checkPrice(price,car.getPrice())!=true){
           	System.out.println("plz reput price as it lass than car price");
           	price =s.nextInt();
           }
          
           System.out.print(  "  Enter this details ur name address cintact number email ");
           String name = s.nextLine();
           String address = s.nextLine();
           String  contactNumber = s.nextLine();
           String email = s.nextLine();
           ProfileData data =new ProfileData(name,address,contactNumber,email,0);
           Profile customer = new Profile(data);
           d.insertCustomer(customer);
           result="name of customer :"+customer.getName()
           	+"\nname of store    :  "+d.getName()
               +"\ncar model        :" + car.getModel()
               +"\npaid price       :"+car.getPrice()
               + "\n remain          :"+ (price-car.getPrice());
         
       }else if(choise2 == 2) {
       	  result="thank u for visiting us :)";
       }
       return result;
	}
	
	public static boolean checkPrice(double price ,double carPrice){
		return (price>=carPrice);
	}
}
