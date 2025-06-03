package carstore;

import java.util.Scanner;

public class BuyCar {
	public static String buyCar(CarStore carStore){
   	 String result =null ;
   	 System.out.println("welcome  to The Car store :)\n "
   			 + "for veiw inventory enter 1 \n"
   			 + "for search by price enter 2 \n "
   			 + "for search by model enter 3 \n"
   			 + "for search by make entre  4 \n");
       
   	 Scanner input = new Scanner(System.in);
   	 int choise = input.nextInt();
       
   	 switch(choise){
           case 1: 
           	carStore.showInventory();
           	break;
           
           case 2: 
               System.out.println("Enter from and to price plz :)");
               double from= input.nextDouble() ;double to =input.nextDouble();
               carStore.searchByPrice(from, to);
               break;
           
           case 3:               
               System.out.println("Enter model plz :)");
               String model =input.nextLine();
               carStore.searchByModel(model);
               break;
               
           case 4:   
               System.out.println("Enter model plz :)");
               String make =input.nextLine();
               carStore.searchByMake(make);
               break;
   	 }
       
   	 System.out.println("then is there any car u liked it :D plz enter 1 if u want to buy it entre any 0 if there dont");
       
   	 int choise2 = input.nextInt();
       
   	 if(choise2==1) { 
   		 System.out.println("then entre it ID ");
           
   		 int ID = input.nextInt();
           
   		 Vehicle car = carStore.searseCar(ID);
   		 System.out.print("here is it all details  ");
   		 System.out.println( car.toString());
   		 System.out.print( "sure u want it then go to fainlize put it price");
           
   		 double price = input.nextDouble();

           while(checkPrice(price, car.getPrice())!=true){
           	System.out.println("plz reput price as it lass than car price");
           	price =input.nextInt();
           }
          
           System.out.print(  "  Enter this details ur name address cintact number email ");
           String name = input.nextLine();
           String address = input.nextLine();
           String  contactNumber = input.nextLine();
           String email = input.nextLine();
           ProfileData data =new ProfileData(name,address,contactNumber,email,0);
           Profile customer = new Profile(data);
           carStore.insertCustomer(customer);
           result="name of customer :"+customer.getName()
           	+"\nname of store    :  "+carStore.getName()
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
