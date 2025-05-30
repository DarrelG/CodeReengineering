package carstore;
/*
Authors: Salma Ashraf && Ayda Ibrahim .
partener and correction : the leader of team Wafaa Elsaeed
date : during studing at firstTerm and mid trem vacation
Summary of Staff :
1-   Staff class represents  details of Empyees  
*/

/*
 * Smell code   : Long parameter list
 * Reason       : Parameter pada constructor telalu panjang.
 * Solution     : Membuat objek ProfileData untuk mengurangi parameter pada constructor
 * 
 * Smell code   : The Comments
 * Reason       : Banyak komentar yang tidak penting
 * Solution     : Menghapus comment dan mengganti penamaan variable agar lebih deskriptif
 * 
 * Smell code   : Data Class
 * Reason       : Ada Constructor tetapi ada setter
 * Solution     : Menghapus setter pada class Staff
 */

public class Staff extends Profile {
    private String position;
    private double salary;
    private double retier;

    public Staff(ProfileData profileData, String position, double salary, double retier) {
        super(profileData.getName(), profileData.getAddress(), profileData.getContactNumber(), profileData.getEmail(), profileData.getID());
        this.salary = salary;
        this.retier = retier;
        this.position = position;
    }


    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public Double getRetire() {
        return retier;
    }

    @Override
    public Profile clone() {
        ProfileData profileData = new ProfileData(name, address, contactNumber, email, ID);
        return new Staff(profileData, position, salary, retier);
    }

    @Override
    public boolean equals(Object object) {
        Staff staff = (Staff) object;
        return super.equals(object) && staff.getPosition().equals(position)
                && staff.getRetire() == retier && staff.getSalary() == salary;
    }

    @Override
    public String toString() {
        return (super.toString() + "\t" + position + "\t " + salary + "     " + retier);
    }

}
