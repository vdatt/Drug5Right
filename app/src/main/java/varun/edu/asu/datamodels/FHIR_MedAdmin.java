package varun.edu.asu.datamodels;

/**
 * Created by Varun on 11/30/2015.
 */
public class FHIR_MedAdmin {

    private String patientMRN;
    private String patientName;
    private String drug;
    private String NDC;
    private int dose;
    private String doseUnits;
    private String routeOfAdmin;
    private String provider;
    private String timeDue;
    private String timeAdministered;
    private String exception;
    private String dobs;
    private int room;
    private boolean complete;
    private String packaging;
    private String[] allergy;
    private String providerContact;

    public String[] getAllergy() {
        return allergy;
    }

    public void setAllergy(String[] allergy) {
        this.allergy = allergy;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getPatientMRN() {
        return patientMRN;
    }

    public void setPatientMRN(String patientMRN) {
        this.patientMRN = patientMRN;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public String getDoseUnits() {
        return doseUnits;
    }

    public void setDoseUnits(String doseUnits) {
        this.doseUnits = doseUnits;
    }

    public String getRouteOfAdmin() {
        return routeOfAdmin;
    }

    public void setRouteOfAdmin(String routeOfAdmin) {
        this.routeOfAdmin = routeOfAdmin;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getTimeDue() {
        return timeDue;
    }

    public void setTimeDue(String timeDue) {
        this.timeDue = timeDue;
    }

    public boolean isComplete() {return complete;}

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getTimeAdministered() {
        return timeAdministered;
    }

    public void setTimeAdministered(String timeAdministered) {
        this.timeAdministered = timeAdministered;
    }

    public String getNDC() {
        return NDC;
    }

    public void setNDC(String NDC) {
        this.NDC = NDC;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDobs() {
        return dobs;
    }

    public void setDobs(String dobs) {
        this.dobs = dobs;
    }
    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getProviderContact() {
        return providerContact;
    }

    public void setProviderContact(String providerContact) {
        this.providerContact = providerContact;
    }
}
