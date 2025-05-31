package carstore;
/*
Authors: Salma Ashraf && Ayda Ibrahim  .
partener and correction : the leader of team Wafaa Elsaeed
date : during studing at firstTerm.
Summary of Profile: 
1-  purpose of this class is make some thing that has common attributes of many classes in our project
2- to reduce the code written 
*/
 // smell code : Data class
// reason : Sudah ada constructor ada setter lagi
// solution : remove setter and use constructor only

// smell code : the comments
// reason : ada komentar yang tidak perlu
// solution : remove the comments that not needed
public class Profile {
    
   protected String name ;
   protected String address ;
   protected String contactNumber ;
   protected String email ;
   protected int ID ;
   
   
   public Profile(String name,String address,String contactNumber,String email,int ID){
       this.ID=ID;
       this.address=address;
       this.email=email;
       this.name=name;
       this.contactNumber=contactNumber;
   }
   
   

public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return ID;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%d", name, address, contactNumber, email, ID);
    }

    @Override
    public Profile clone() {
        return new Profile(name, address, contactNumber, email, ID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Profile)) return false;

        Profile other = (Profile) obj;
        return ID == other.ID &&
                name.equals(other.name) &&
                address.equals(other.address) &&
                contactNumber.equals(other.contactNumber) &&
                email.equals(other.email);
    }
     @Override
    public int hashCode() {
        return java.util.Objects.hash(name, address, contactNumber, email, ID);
    }
}