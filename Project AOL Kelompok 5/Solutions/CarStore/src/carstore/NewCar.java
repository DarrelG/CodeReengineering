package carstore;

/*
Authors: Esraa Ebrahem && Wafaa Elsaeed .
partener and correction : the leader of team Wafaa Elsaeed
date : during studing at firstTerm.
Summary of New Car :
1- Represent details of new cars
*/

/*
 * Code Smell   : Long Parameter List
 * Reason       : Constructor memiliki terlalu banyak parameter (14 parameter)
 * Solution     : Menggunakan VehicleData class untuk mengurangi parameter
 * 
 * Code Smell   : The Comments
 * Reason       : Komentar yang tidak memberikan informasi berguna
 * Solution     : Menghapus komentar redundan dan memperbaiki dokumentasi
 * 
 * Code Smell   : Duplicate Code
 * Reason       : Method clone() dan equals() mengulang kode dari parent class
 * Solution     : Menyederhanakan implementasi dengan memanfaatkan parent class
 */

public class NewCar extends Vehicle {

    public NewCar(VehicleData vehicleData) {
        super(vehicleData);
    }

    @Override
    public String toString() {
        return super.toString();
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
        return new NewCar(data);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}