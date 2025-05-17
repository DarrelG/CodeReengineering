package carstore;

public class GenerateRandom {
	public static int randomNumber(int up,int lower){
        return (int)(Math.random()*(up-lower)+lower);
    }

	public static boolean randomBoolean() {
		return Math.random() < 0.5;
	}
     
    public static String randomName(){
    	int random= (int)(Math.random()*11);
    	switch(random){
           case 0: return "Ahmed  ";
           case 1: return "mai    ";
           case 2: return "mahmoud";
           case 3: return "mona   ";
           case 4: return "wafaa  ";
           case 5: return "eman   ";
           case 6: return "fatema ";
           case 7: return "somaya ";
           case 8: return "abeer  ";
           case 9: return "Ayda   ";
           case 10:return "Esraa  ";
           case 11:return "salma  ";
           default:return "UN RECHABLE CODE!";
       }
    }
      
    public static String randomPosition(){
    	int random= (int)(Math.random()*10);
    	switch(random){
           case 0 : return "Office Manager               " ;
           case 1 : return "Title Department Laurel      " ;
           case 2 : return "Title Department Salisbury   " ;
           case 3 : return "Finance Manager              " ;
           case 4 : return "Sales Consultant             " ;
           case 5 : return"Business Development         " ;
           case 6 : return"Business Development Manager " ;
           case 7 : return"Sales Manager                " ;
           case 8 : return "Service Advisor              " ;
           case 9 : return"Service Writer               " ;
           case 10: return"Service Manager              " ;
           default: return "UN RECHABLE CODE!";
       }
    }

    public static String randomColour(){
    	int random= (int)(Math.random()*11);
    	switch(random){
           	case 0 : return "red    ";
           	case 1 : return "pink   ";
           	case 2 : return "thistle";
           	case 3 : return "violet ";
           	case 4 : return "purple ";
           	case 5 : return"blue   ";
           	case 6 : return"steelb ";
           	case 7 : return"green  ";
           	case 8 : return "ivory  ";
           	case 9 : return "yellow ";
           	case 10: return"wheat  ";
           	case 11: return"black  ";
           	default: return "UN RECHABLE CODE!";
    	}
    }
      
    public static String randomMake(){
    	int random= (int)(Math.random()*5);
    	switch(random){
    		case 0:return "Hyundai ";
    		case 1:return "BMW     ";
    		case 2 :return"Ferrari ";
    		case 3 :return"Kia     ";
    		case 4 :return"Smart   ";
    		case 5 :return"Ford    ";
    		default:return "UN RECHABLE CODE!";
    	}
    } 
      
    public static String randomModel(String make){
    	String model = null ;
    	int random= (int)(Math.random()*2);
    	switch(make){
    		case "Ferrari " :{
    			switch(random){
    				case 0:
    					model = "Daytona                ";
    					break;
    					
    				case 1:
    					model = "250 GTO                ";
    					break;
    					
    				case 2:
    					model = "275                    ";
    					break;
    					
    				default:
    					model = "UN RECHABLE CODE!";
    			}
    		} 
    		break;
    		case "BMW     " :{ 
    			switch(random){
    			case 0: model = "2017 -330 Gran Turismo "; 	break;
    			case 1: model = "2017 BMW 328d          ";	break;
    			case 2: model = "2017 BMW 230           ";	break;
    			default:model = "UN RECHABLE CODE!";		break;
    			}
    		}
    		break; 
    		case "Kia     ":{ 
    			switch(random){
    				case 0: model = "2017 Kia Cadenza       ";	break;
    				case 1: model = "2016 Kia Sorento       ";	break;
    				case 2: model = "2016 Kia Optima        ";	break;
    				default:model = "UN RECHABLE CODE!";		break;
    			}
    		} 
    		break;
    		case"Hyundai ":{ 
    			switch(random){
    				case 0: model =  "2017 Hyundai           ";	break;
    				case 1: model =  "2016 Hyundai Accent    ";	break;
    				case 2: model =  "2016 Hyundai Genes Cope";	break;
    				default:model="UN RECHABLE CODE!";			break;
    			}
    		} 
    		break;
    		case "Smart   " :{ 
    			switch(random){
    				case 0: model = "2016 smart fortwo      ";	break;
    				case 1: model = "2016 F2 Electric D     ";	break;
    				case 2: model = "2017 smart fortwo      ";	break;
    				default:model = "UN RECHABLE CODE!";		break;
    			}
    		}
    		break;
            case  "Ford    ":{ 
            	switch(random){
            		case 0: model = "2016 Ford Flex         ";	break;
            		case 1: model = "2016 Ford C-Max Hybrid ";	break;
            		default:model = "UN RECHABLE CODE!";		break;
            	}
            }
            break;
    	} 
    	return model;
    }
       
    public static String randomCountry(){
    	int random= (int)(Math.random()*11);
    	switch(random){
    		case 0 :return "China        ";
    		case 1 :return "United States";
    		case 2 :return "Japan        ";
    		case 3 :return "Germany      ";
    		case 4 :return "egypt        ";
    		case 5 :return"India        ";
    		case 6 :return"Turkey       ";
    		case 7 :return"Iran         ";
    		case 8 :return "Portugal     ";
    		case 9 :return"Kenya        ";
    		case 10 :return"Belgium      ";
    		case 11 :return"Peru         ";
    		default :return "UN RECHABLE CODE!";
       }
    } 
        
    public static String randomFuelType(){
    	int random= (int)(Math.random()*4);
    	switch(random){
    		case 0 :return "Petrol  ";
    		case 1 :return "Diesel  ";
    		case 2 :return "LPG     ";
    		case 3 :return "gas     ";
    		case 4 :return "Biofuels";
    		default :return "UN RECHABLE CODE!";
    	}
    }
}
