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


// smell code : Long parameter list
// reason : parameter pada constructor terlalu panjang
// solution : membuat objek ProfileData untuk mengurangi parameter pada constructor


import java.util.Objects;

public class Profile {

    private final ProfileData data;

    public Profile(ProfileData data) {
        this.data = data;
    }

    public String getName() {
        return data.getName();
    }

    public String getAddress() {
        return data.getAddress();
    }

    public String getContactNumber() {
        return data.getContactNumber();
    }

    public String getEmail() {
        return data.getEmail();
    }

    public int getId() {
        return data.getID();
    }

    @Override
public String toString() {
    return String.format("%s\t%s\t%s\t%s\t%d",
            getName(),
            getAddress(),
            getContactNumber(),
            getEmail(),
            getId());
}

@Override
public Profile clone() {
    return new Profile(new ProfileData(
            getName(),
            getAddress(),
            getContactNumber(),
            getEmail(),
            getId()));
}

@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Profile other = (Profile) obj;
    return getId() == other.getId() &&
           Objects.equals(getName(), other.getName()) &&
           Objects.equals(getAddress(), other.getAddress()) &&
           Objects.equals(getContactNumber(), other.getContactNumber()) &&
           Objects.equals(getEmail(), other.getEmail());
}

@Override
public int hashCode() {
    return Objects.hash(getName(), getAddress(),
            getContactNumber(), getEmail(), getId());
}

}
