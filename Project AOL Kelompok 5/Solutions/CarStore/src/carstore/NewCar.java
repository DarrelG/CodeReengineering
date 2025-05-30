package carstore;
/*
Authors: Esraa Ebrahem && Wafaa Elsaeed .
partener and correction : the leader of team Wafaa Elsaeed
date : during studing at firstTerm.
Summary of New Car :
1- represent details of  new cars
*/

/*
 * Code Smell: Long Parameter List
 * Reason: Constructor memiliki 14 parameter yang terlalu banyak
 * Solution: Gunakan Builder Pattern atau Parameter Object
 * 
 * Code Smell: Useless Override
 * Reason: Method toString() dan equals() hanya memanggil super method tanpa menambah fungsi apapun
 * Solution: Hapus override yang tidak perlu, biarkan menggunakan implementasi parent class
 * 
 * Code Smell: Comments
 * Reason: Komentar yang tidak memberikan nilai tambah dan hanya menjelaskan syntax dasar
 * Solution: Hapus komentar yang tidak perlu
 * 
 * Code Smell: Dead Code
 * Reason: Class ini tidak menambah behavior apapun dibanding parent class, hanya wrapper kosong
 * Solution: Tambahkan specific behavior untuk new car atau pertimbangkan penggabungan dengan Vehicle
 */

public class NewCar extends Vehicle {
    
    private int warrantyPeriodMonths;
    private boolean hasExtendedWarranty;

    public NewCar(String model, String make, String madeIn, String colour, String fuelType,
                  int ID, double speed, double power, double price, int yearIntroduced,
                  boolean airbags, boolean heater, boolean speakers, boolean fogLamps) {
        super(model, make, madeIn, colour, fuelType, ID, speed, power, price, 
              yearIntroduced, airbags, heater, speakers, fogLamps);
        this.warrantyPeriodMonths = 36;
        this.hasExtendedWarranty = false;
    }

    public NewCar(VehicleData vehicleData) {
        super(vehicleData.model, vehicleData.make, vehicleData.madeIn, vehicleData.colour,
              vehicleData.fuelType, vehicleData.id, vehicleData.speed, vehicleData.power,
              vehicleData.price, vehicleData.yearIntroduced, vehicleData.airbags,
              vehicleData.heater, vehicleData.speakers, vehicleData.fogLamps);
        this.warrantyPeriodMonths = 36;
        this.hasExtendedWarranty = false;
    }

    public NewCar(VehicleData vehicleData, int warrantyPeriodMonths, boolean hasExtendedWarranty) {
        this(vehicleData);
        this.warrantyPeriodMonths = warrantyPeriodMonths;
        this.hasExtendedWarranty = hasExtendedWarranty;
    }

    public int getWarrantyPeriodMonths() {
        return warrantyPeriodMonths;
    }

    public void setWarrantyPeriodMonths(int warrantyPeriodMonths) {
        this.warrantyPeriodMonths = warrantyPeriodMonths;
    }

    public boolean hasExtendedWarranty() {
        return hasExtendedWarranty;
    }

    public void setExtendedWarranty(boolean hasExtendedWarranty) {
        this.hasExtendedWarranty = hasExtendedWarranty;
    }

    public boolean isWarrantyValid() {
        return warrantyPeriodMonths > 0;
    }

    public double calculateWarrantyValue() {
        return getPrice() * 0.1 * (warrantyPeriodMonths / 12.0);
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format("\tWarranty: %d months\tExtended: %s", 
                           warrantyPeriodMonths, hasExtendedWarranty);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewCar)) return false;
        if (!super.equals(o)) return false;
        
        NewCar newCar = (NewCar) o;
        return warrantyPeriodMonths == newCar.warrantyPeriodMonths &&
               hasExtendedWarranty == newCar.hasExtendedWarranty;
    }

    public NewCar createCopy() {
        NewCar copy = new NewCar(getModel(), getMake(), getMadeIn(), getColour(), getFuelType(),
                                getId(), getSpeed(), getPower(), getPrice(), getYearIntroduced(),
                                getAirbags(), getHeater(), getSpeakers(), getFogLamps());
        copy.warrantyPeriodMonths = this.warrantyPeriodMonths;
        copy.hasExtendedWarranty = this.hasExtendedWarranty;
        return copy;
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
}
