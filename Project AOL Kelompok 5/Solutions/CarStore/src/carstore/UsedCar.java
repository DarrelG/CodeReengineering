package carstore;
/*
Authors:  Somaya Mohamed&& Abeer Ragab .
partener and correction : the leader of team Wafaa Elsaeed
date : during studing at firstTerm and mid trem vacation
Summary of Used Car: 
1- Repesent used cars detials 
*/


/*
 * Code Smell: Long Parameter List
 * Reason: Constructor memiliki 17 parameter yang sangat panjang dan sulit dibaca
 * Solution: Gunakan Builder Pattern untuk mengelompokkan parameter terkait
 * 
 * Code Smell: Inconsistent Naming Convention
 * Reason: Nama variabel tidak konsisten (KilometerTravel menggunakan PascalCase, seharusnya camelCase)
 * Solution: Ubah menjadi kilometerTravel sesuai konvensi Java
 * 
 * Code Smell: Comments
 * Reason: Banyak komentar yang tidak memberikan informasi berguna dan hanya menjelaskan hal yang sudah jelas dari kode
 * Solution: Hapus komentar yang redundan, pertahankan hanya yang memberikan konteks bisnis
 * 
 * Code Smell: Inappropriate Intimacy
 * Reason: Method clone() mengakses langsung field private dari parent class tanpa menggunakan getter
 * Solution: Gunakan copy constructor pattern dengan proper encapsulation
 */

public class UsedCar extends Vehicle {
    
    private double kilometerTravel;
    private boolean repair;
    private int numberOfOwners;

    public UsedCar(String model, String make, String madeIn, String colour, String fuelType,
                   int id, double speed, double power, double price, int yearIntroduced,
                   boolean airbags, boolean heater, boolean speakers, boolean fogLamps,
                   double kilometerTravel, int numberOfOwners, boolean repair) {
        super(model, make, madeIn, colour, fuelType, id, speed, power, price, 
              yearIntroduced, airbags, heater, speakers, fogLamps);
        this.kilometerTravel = kilometerTravel;
        this.numberOfOwners = numberOfOwners;
        this.repair = repair;
    }

    public UsedCar(VehicleData vehicleData, UsedCarData usedCarData) {
        super(vehicleData.model, vehicleData.make, vehicleData.madeIn, vehicleData.colour,
              vehicleData.fuelType, vehicleData.id, vehicleData.speed, vehicleData.power,
              vehicleData.price, vehicleData.yearIntroduced, vehicleData.airbags,
              vehicleData.heater, vehicleData.speakers, vehicleData.fogLamps);
        this.kilometerTravel = usedCarData.kilometerTravel;
        this.numberOfOwners = usedCarData.numberOfOwners;
        this.repair = usedCarData.repair;
    }

    public void setKilometerTravel(double kilometerTravel) {
        this.kilometerTravel = kilometerTravel;
    }

    public double getKilometerTravel() {
        return kilometerTravel;
    }

    public void setRepair(boolean repair) {
        this.repair = repair;
    }

    public boolean getRepair() {
        return repair;
    }

    public int getNumberOfOwners() {
        return numberOfOwners;
    }

    public void setNumberOfOwners(int numberOfOwners) {
        this.numberOfOwners = numberOfOwners;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + getKilometerTravel() + "\t " + numberOfOwners + getRepair() + "\n";
    }

    public UsedCar createCopy() {
        return new UsedCar(getModel(), getMake(), getMadeIn(), getColour(), getFuelType(),
                          getId(), getSpeed(), getPower(), getPrice(), getYearIntroduced(),
                          getAirbags(), getHeater(), getSpeakers(), getFogLamps(),
                          kilometerTravel, numberOfOwners, repair);
    }

    @Override
    public boolean equals(Object m) {
        if (this == m) return true;
        if (!(m instanceof UsedCar)) return false;
        if (!super.equals(m)) return false;
        
        UsedCar car = (UsedCar) m;
        return Double.compare(car.kilometerTravel, kilometerTravel) == 0 && 
               car.repair == repair &&
               car.numberOfOwners == numberOfOwners;
    }

    public static class VehicleData {
        public String model, make, madeIn, colour, fuelType;
        public int id, yearIntroduced;
        public double speed, power, price;
        public boolean airbags, heater, speakers, fogLamps;
        
        public VehicleData(String model, String make, String madeIn, String colour, String fuelType,
                          int id, double speed, double power, double price, int yearIntroduced,
                          boolean airbags, boolean heater, boolean speakers, boolean fogLamps) {
            this.model = model; this.make = make; this.madeIn = madeIn; this.colour = colour;
            this.fuelType = fuelType; this.id = id; this.speed = speed; this.power = power;
            this.price = price; this.yearIntroduced = yearIntroduced; this.airbags = airbags;
            this.heater = heater; this.speakers = speakers; this.fogLamps = fogLamps;
        }
    }
    
    public static class UsedCarData {
        public double kilometerTravel;
        public int numberOfOwners;
        public boolean repair;
        
        public UsedCarData(double kilometerTravel, int numberOfOwners, boolean repair) {
            this.kilometerTravel = kilometerTravel;
            this.numberOfOwners = numberOfOwners;
            this.repair = repair;
        }
    }
}
