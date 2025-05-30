package carstore;

public class VehicleData {
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

    public VehicleData(String model, String make, String madeIn, String colour, String FuelType, int ID,
            double speed, double power, double price, int YearIntroduced, boolean Airbags,
            boolean Heater, boolean Speakers, boolean FogLamps) {
        this.Speakers = Speakers;
        this.Heater = Heater;
        this.Airbags = Airbags;
        this.FogLamps = FogLamps;
        this.FuelType = FuelType;
        this.model = model;
        this.make = make;
        this.ID = ID;
        this.colour = colour;
        this.power = power;
        this.price = price;
        this.YearIntroduced = YearIntroduced;
        this.speed = speed;
        this.madeIn = madeIn;
    }

    public String getModel() {
        return model;
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

    public String getFuelType() {
        return FuelType;
    }

    public double getSpeed() {
        return speed;
    }

    public double getPrice() {
        return price;
    }

    public int getID() {
        return ID;
    }

    public double getPower() {
        return power;
    }

    public int getYearIntroduced() {
        return YearIntroduced;
    }

    public boolean getAirbags() {
        return Airbags;
    }

    public boolean getHeater() {
        return Heater;
    }

    public boolean getSpeakers() {
        return Speakers;
    }

    public boolean getFogLamps() {
        return FogLamps;
    }
}