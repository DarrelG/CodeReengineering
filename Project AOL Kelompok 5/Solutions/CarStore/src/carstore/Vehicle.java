package carstore;

/*
Authors: Eman Hemeda && Eman Awad && Fatma Nabil.
partener and correction : the leader of team Wafaa Elsaeed
date : during studing at firstTerm and mid trem vacation
Summary of Vehicle:
the porbuse of this Vehicle is 
1- being the parent of UsedCar and NewCar class
2- showing details of cars
3- collection of most of types of cars.
*/

/*
 * Smell code   :
 * Reason       : the class Vehicle is too large and has many attributes
 * Solution     :  we can use the interface to reduce the size of this class
 * 
 * Smell code   : The Comments
 * Reason       : Banyak komentar yang tidak penting
 * Solution     : Menghapus comment dan mengganti penamaan variable agar lebih deskriptif
 * 
 * Smell code   : Data Class
 * Reason       : Ada Constructor tetapi ada setter
 * Solution     : Menghapus setter pada class Staff
 * 
 * Smell code   : Deficient Encapsulation
 * Reason       : Sudah berupaya melakukan encapsulation, tetapi access modifiernya salah
 * Solution     : Ubah access modifier pada atribut menjadi private
 */

public class Vehicle {
        private String model;
        private String make;
        private String madeIn;
        private String colour;
        private String FuelType;
        private double speed;
        private double price;
        private int ID;
        private double power;
        private int YearIntroduced;
        private boolean Airbags;
        private boolean Heater;
        private boolean Speakers;
        private boolean FogLamps;

        public Vehicle(VehicleData data) {
                this.model = data.getModel();
                this.make = data.getMake();
                this.madeIn = data.getMadeIn();
                this.colour = data.getColour();
                this.FuelType = data.getFuelType();
                this.ID = data.getID();
                this.speed = data.getSpeed();
                this.power = data.getPower();
                this.price = data.getPrice();
                this.YearIntroduced = data.getYearIntroduced();
                this.Airbags = data.getAirbags();
                this.Heater = data.getHeater();
                this.Speakers = data.getSpeakers();
                this.FogLamps = data.getFogLamps();
        }

        // Description: this function is type of override which used to show details
        // ofatributes of class vehicle.

        @Override
        public String toString() {
                return "" + getModel() + "\t" + getMake() + "\t" + YearIntroduced +
                                "\t" + getMadeIn() +
                                "\t" + getColour() + "\t" + FuelType + "\t" + getSpeed() + "\t" + ID + "\t"
                                + getPower() + "\t" + price + "\t  " + getAirbags() + "\t " + getHeater() +
                                "\t  " + getSpeakers()
                                + "\t " + getFogLamps() + "\n";
        }

        // Description:the purpose of this fuction :- copy of the object on which it is
        // called

        @Override
        public Vehicle clone() {
                VehicleData data = new VehicleData(
                                this.model,
                                this.make,
                                this.madeIn,
                                this.colour,
                                this.FuelType,
                                this.ID,
                                this.speed,
                                this.power,
                                this.price,
                                this.YearIntroduced,
                                this.Airbags,
                                this.Heater,
                                this.Speakers,
                                this.FogLamps);

                return new Vehicle(data);
        }

        // Description:the purpose of this fuction :- compare the object on which it is
        // called with its parmeters
        @Override
        public boolean equals(Object object) {
                Vehicle car = (Vehicle) object;
                return car.make.equals(make) && car.colour.equals(colour)
                                && car.madeIn.equals(madeIn) && car.model.equals(model)
                                && car.power == power && car.speed == speed && car.price == price
                                && car.getSpeakers() == Speakers &&
                                FogLamps == car.getFogLamps() &&
                                Heater == car.getHeater() && Airbags == car.getAirbags();
        }

        /*
         * summary of this function
         * parameters : no thing
         * Return :( String )
         * Description:the purpose of this fuction :- show the basic details of any
         * vehicle
         */

        public String showDetetails() {
                return "" + getModel() + " " + getMake() + " " +
                                " " + getMadeIn() +
                                " " + getColour() + "   " + FuelType + "\t       " + YearIntroduced + "\t\t"
                                + getSpeed() + "     " + ID + "\t"
                                + getPower() + "\t" + price;
        }

        public boolean getAirbags() {
                return Airbags;
        }

        public boolean getHeater() {
                return Heater;
        }

        public boolean getFogLamps() {
                return FogLamps;
        }

        public boolean getSpeakers() {
                return Speakers;
        }

        public String getModel() {
                return model;
        }

        public String getFuelType() {
                return FuelType;
        }

        public String getMake() {
                return make;
        }

        public String getMadeIn() {
                return madeIn;
        }

        public String getColour() {
                return colour;
        }

        public int getID() {
                return ID;
        }

        public int getYearIntroduced() {
                return YearIntroduced;
        }

        public double getSpeed() {
                return speed;
        }

        public double getPower() {
                return power;
        }

        public double getPrice() {
                return price;
        }

}
