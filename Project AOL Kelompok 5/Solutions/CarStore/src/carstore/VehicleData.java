package carstore;

public class VehicleData {
    private String model;
    private String make;
    private String madeIn;
    private String colour;
    private String fuelType;
    private double speed;
    private double price;
    private int iD;
    private double power;
    private int yearIntroduced;
    private boolean airbags;
    private boolean heater;
    private boolean speakers;
    private boolean fogLamps;

    public VehicleData(String model, String make, String madeIn, String colour, String fuelType, int iD,
            double speed, double power, double price, int yearIntroduced, boolean airbags,
            boolean heater, boolean speakers, boolean fogLamps) {
        this.speakers = speakers;
        this.heater = heater;
        this.airbags = airbags;
        this.fogLamps = fogLamps;
        this.fuelType = fuelType;
        this.model = model;
        this.make = make;
        this.iD = iD;
        this.colour = colour;
        this.power = power;
        this.price = price;
        this.yearIntroduced = yearIntroduced;
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
        return fuelType;
    }

    public double getSpeed() {
        return speed;
    }

    public double getPrice() {
        return price;
    }

    public int getID() {
        return iD;
    }

    public double getPower() {
        return power;
    }

    public int getYearIntroduced() {
        return yearIntroduced;
    }

    public boolean getAirbags() {
        return airbags;
    }

    public boolean getHeater() {
        return heater;
    }

    public boolean getSpeakers() {
        return speakers;
    }

    public boolean getFogLamps() {
        return fogLamps;
    }
}