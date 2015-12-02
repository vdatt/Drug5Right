package varun.edu.asu.datamodels;

/**
 * Created by Varun on 11/30/2015.
 */
public class FHIR_MedPres {
    private int patientMRN;
    private String drug;
    private int dose;
    private String doseUnits;
    private String routeOfAdmin;
    private String provider;
    private String timeDue;

    public int getPatientMRN() {
        return patientMRN;
    }

    public void setPatientMRN(int patientMRN) {
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
}
