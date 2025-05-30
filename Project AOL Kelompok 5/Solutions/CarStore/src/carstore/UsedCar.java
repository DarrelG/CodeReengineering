package carstore;

/*
Authors:  Somaya Mohamed&& Abeer Ragab .
partener and correction : the leader of team Wafaa Elsaeed
date : during studing at firstTerm and mid trem vacation
Summary of Used Car: 
1- Repesent used cars detials 
*/

/*
 * Code Smell: Long Parameter List - COMPLETELY RESOLVED
 * Reason: Tidak ada constructor atau method dengan lebih dari 3 parameter
 * Solution: Gunakan field assignment dan helper methods
 * 
 * Code Smell: Magic Numbers
 * Reason: tidak memiliki makna yang jelas dan sulit dipahami
 * Solution: Named constants dengan meaningful names
 * 
 * Code Smell: Primitive Obsession  
 * Reason : Menggunakan primitive types tanpa validation
 * Solution: Input validation di constructor dan setter
 */

public class NewCar extends Vehicle {
    
    private static final double WARRANTY_RATE = 0.1;
    private static final double MONTHS_IN_YEAR = 12.0;
    private static final int DEFAULT_WARRANTY_MONTHS = 36;
    
    private int warrantyPeriodMonths;
    private boolean hasExtendedWarranty;

    public NewCar(CarConfig config) {
        super(createVehicleParams(config));
        initializeWarranty(config.warrantyPeriodMonths, config.hasExtendedWarranty);
    }

    public NewCar(String model, String make, double price) {
        this(new CarConfig(model, make, price));
    }

    // Helper method untuk menghindari long parameter list
    private static VehicleParams createVehicleParams(CarConfig config) {
        VehicleParams params = new VehicleParams();
        params.model = config.model;
        params.make = config.make;
        params.madeIn = config.madeIn;
        params.colour = config.colour;
        params.fuelType = config.fuelType;
        params.id = config.id;
        params.speed = config.speed;
        params.power = config.power;
        params.price = config.price;
        params.yearIntroduced = config.yearIntroduced;
        params.airbags = config.airbags;
        params.heater = config.heater;
        params.speakers = config.speakers;
        params.fogLamps = config.fogLamps;
        return params;
    }

    private void initializeWarranty(int warrantyMonths, boolean extendedWarranty) {
        setWarrantyPeriodMonths(warrantyMonths);
        this.hasExtendedWarranty = extendedWarranty;
    }

    public int getWarrantyPeriodMonths() {
        return warrantyPeriodMonths;
    }

    public void setWarrantyPeriodMonths(int warrantyPeriodMonths) {
        if (warrantyPeriodMonths < 0) {
            throw new IllegalArgumentException("Warranty period cannot be negative");
        }
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
        return getPrice() * WARRANTY_RATE * (warrantyPeriodMonths / MONTHS_IN_YEAR);
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

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + warrantyPeriodMonths;
        result = 31 * result + (hasExtendedWarranty ? 1 : 0);
        return result;
    }

    public static class CarConfig {
        public final String model, make;
        public final double price;
        
        public String madeIn = "Unknown";
        public String colour = "White";
        public String fuelType = "Gasoline";
        public int id = 0;
        public double speed = 120.0;
        public double power = 150.0;
        public int yearIntroduced = 2024;
        public boolean airbags = true;
        public boolean heater = true;
        public boolean speakers = false;
        public boolean fogLamps = false;
        public int warrantyPeriodMonths = DEFAULT_WARRANTY_MONTHS;
        public boolean hasExtendedWarranty = false;

        public CarConfig(String model, String make, double price) {
            this.model = validateRequired(model, "Model");
            this.make = validateRequired(make, "Make");
            this.price = validatePrice(price);
        }

        private String validateRequired(String value, String fieldName) {
            if (value == null || value.trim().isEmpty()) {
                throw new IllegalArgumentException(fieldName + " is required");
            }
            return value.trim();
        }

        private double validatePrice(double price) {
            if (price <= 0) {
                throw new IllegalArgumentException("Price must be positive");
            }
            return price;
        }

        public boolean isValid() {
            return model != null && !model.trim().isEmpty() &&
                   make != null && !make.trim().isEmpty() &&
                   price > 0 &&
                   warrantyPeriodMonths >= 0;
        }

        public boolean hasLuxuryFeatures() {
            return airbags && heater && speakers && fogLamps;
        }

        public boolean isElectricOrHybrid() {
            return "Electric".equalsIgnoreCase(fuelType) || 
                   "Hybrid".equalsIgnoreCase(fuelType);
        }
    }

    // Simple data container - no constructor parameters
    public static class VehicleParams {
        public String model, make, madeIn, colour, fuelType;
        public int id, yearIntroduced;
        public double speed, power, price;
        public boolean airbags, heater, speakers, fogLamps;
    }
}