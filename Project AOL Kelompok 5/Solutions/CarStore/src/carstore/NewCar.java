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
 * Reason: Semua constructor dan method menggunakan maksimal 3-4 parameter
 * Solution: Konsisten menggunakan Parameter Object Pattern di semua level
 * 
 * Code Smell: Magic Numbers
 * Reason: Semua magic numbers sudah diextract ke named constants
 * Solution: Named constants dengan meaningful names
 * 
 * Code Smell: Primitive Obsession
 * Reason: Validation mencegah invalid state
 * Solution: Input validation di constructor dan setter
 */

public class NewCar extends Vehicle {
    
    private static final double WARRANTY_RATE = 0.1;
    private static final double MONTHS_IN_YEAR = 12.0;
    private static final int DEFAULT_WARRANTY_MONTHS = 36;

    public static double getWARRANTY_RATE() {
        return WARRANTY_RATE;
    }
    
    private int warrantyPeriodMonths;
    private boolean hasExtendedWarranty;

    public NewCar(CarConfig config) {
        super(config); // Pass config directly to parent
        initializeWarranty(config.warrantyPeriodMonths, config.hasExtendedWarranty);
    }

    public NewCar(String model, String make, double price) {
        this(new CarConfig(model, make, price));
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

    public static class CarConfig {
        // Required fields
        public final String model, make;
        public final double price;
        
        // Optional fields dengan default values
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

        // Constructor hanya dengan 3 required parameters
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

        // Helper methods untuk readability
        public boolean hasLuxuryFeatures() {
            return airbags && heater && speakers && fogLamps;
        }

        public boolean isElectricOrHybrid() {
            return "Electric".equalsIgnoreCase(fuelType) || 
                   "Hybrid".equalsIgnoreCase(fuelType);
        }
    }
}
