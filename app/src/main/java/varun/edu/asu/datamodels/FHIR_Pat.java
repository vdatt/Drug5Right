package varun.edu.asu.datamodels;


import java.util.Date;
/**
 * Created by Varun on 11/27/2015.
 */
public class FHIR_Pat {

    /*
    import org.hl7.fhir.model.Patient;
        Patient pat = new Patient();
     */

    private int MRN;
    private String name;
    private int room;
    private String gender;
    private String provider;
    private String providerContact;
    private String dob;
    private String[] allergies;

    public int getMRN() {
        return MRN;
    }

    public void setMRN(int MRN) {
        this.MRN = MRN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderContact() {
        return providerContact;
    }

    public void setProviderContact(String providerContact) {
        this.providerContact = providerContact;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String[] getAllergies() {
        return allergies;
    }

    public void setAllergies(String[] allergies) {
        this.allergies = allergies;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
