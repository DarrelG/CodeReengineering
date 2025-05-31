package carstore;

/*
Authors:  Somaya Mohamed&& Abeer Ragab .
partener and correction : the leader of team Wafaa Elsaeed
date : during studing at firstTerm and mid trem vacation
Summary of Used Car: 
1- Represent used cars details 
*/

/*
 * Code Smell   : Long Parameter List
 * Reason       : Constructor memiliki terlalu banyak parameter (17 parameter)
 * Solution     : Menggunakan VehicleData class dan menambahkan parameter khusus UsedCar
 * 
 * Code Smell   : The Comments
 * Reason       : Banyak komentar yang tidak penting dan tidak informatif
 * Solution     : Menghapus komentar yang redundan dan memperbaiki penamaan method
 * 
 * Code Smell   : Data Class with Setters
 * Reason       : Ada constructor tetapi masih ada setter method
 * Solution     : Menghapus setter method untuk immutability
 * 
 * Code Smell   : Inconsistent Naming
 * Reason       : Penamaan variable tidak konsisten (KilometerTravel vs NoOfOwners)
 * Solution     : Menggunakan camelCase yang konsisten
 */

public class UsedCar extends Vehicle {
    
    private double kilometerTravel;
    private boolean repair;
    private int numberOfOwners;

    public UsedCar(VehicleData vehicleData, double kilometerTravel, int numberOfOwners, boolean repair) {
        super(vehicleData);
        this.kilometerTravel = kilometerTravel;
        this.repair = repair;
        this.numberOfOwners = numberOfOwners;
    }

    public double getKilometerTravel() {
        return kilometerTravel;
    }

    public boolean getRepair() {
        return repair;
    }

    public int getNumberOfOwners() {
        return numberOfOwners;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + getKilometerTravel() + "\t " + numberOfOwners + getRepair() + "\n";
    }

    @Override
    public Vehicle clone() {
        VehicleData data = new VehicleData(
                getModel(),
                getMake(),
                getMadeIn(),
                getColour(),
                getFuelType(),
                getID(),
                getSpeed(),
                getPower(),
                getPrice(),
                getYearIntroduced(),
                getAirbags(),
                getHeater(),
                getSpeakers(),
                getFogLamps()
        );
        return new UsedCar(data, kilometerTravel, numberOfOwners, repair);
    }

    @Override
    public boolean equals(Object m) {
        UsedCar car = (UsedCar) m;
        return super.equals(m) && car.kilometerTravel == kilometerTravel && car.repair == repair;
    }
}