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
        private String fuelType;
        private double speed;
        private double price;
        private int ID;
        private double power;
        private int yearIntroduced;
        private boolean airbags;
        private boolean heater;
        private boolean speakers;
        private boolean fogLamps;

        public Vehicle(VehicleData data) {
                this.model = data.getModel();
                this.make = data.getMake();
                this.madeIn = data.getMadeIn();
                this.colour = data.getColour();
                this.fuelType = data.getFuelType();
                this.ID = data.getID();
                this.speed = data.getSpeed();
                this.power = data.getPower();
                this.price = data.getPrice();
                this.yearIntroduced = data.getYearIntroduced();
                this.airbags = data.getAirbags();
                this.heater = data.getHeater();
                this.speakers = data.getSpeakers();
                this.fogLamps = data.getFogLamps();
        }

        @Override
        public String toString() {
                return "" + getModel() + "\t" + getMake() + "\t" + yearIntroduced +
                                "\t" + getMadeIn() +
                                "\t" + getColour() + "\t" + fuelType + "\t" + getSpeed() + "\t" + ID + "\t"
                                + getPower() + "\t" + price + "\t  " + getAirbags() + "\t " + getHeater() +
                                "\t  " + getSpeakers()
                                + "\t " + getFogLamps() + "\n";
        }

        @Override
        public Vehicle clone() {
                VehicleData data = new VehicleData(
                                this.model,
                                this.make,
                                this.madeIn,
                                this.colour,
                                this.fuelType,
                                this.ID,
                                this.speed,
                                this.power,
                                this.price,
                                this.yearIntroduced,
                                this.airbags,
                                this.heater,
                                this.speakers,
                                this.fogLamps);

                return new Vehicle(data);
        }

        @Override
        public boolean equals(Object object) {
                Vehicle car = (Vehicle) object;
                return car.make.equals(make) && car.colour.equals(colour)
                                && car.madeIn.equals(madeIn) && car.model.equals(model)
                                && car.power == power && car.speed == speed && car.price == price
                                && car.getSpeakers() == speakers &&
                                fogLamps == car.getFogLamps() &&
                                heater == car.getHeater() && airbags == car.getAirbags();
        }

        public String showDetetails() {
                return "" + getModel() + " " + getMake() + " " +
                                " " + getMadeIn() +
                                " " + getColour() + "   " + fuelType + "\t       " + yearIntroduced + "\t\t"
                                + getSpeed() + "     " + ID + "\t"
                                + getPower() + "\t" + price;
        }

        public boolean getAirbags() {
                return airbags;
        }

        public boolean getHeater() {
                return heater;
        }

        public boolean getFogLamps() {
                return fogLamps;
        }

        public boolean getSpeakers() {
                return speakers;
        }

        public String getModel() {
                return model;
        }

        public String getFuelType() {
                return fuelType;
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
                return yearIntroduced;
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
