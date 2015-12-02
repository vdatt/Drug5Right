package varun.edu.asu.dataEHR_drugKnowledgeBase;

import varun.edu.asu.datamodels.FHIR_Pat;

/**
 * Created by Varun on 11/27/2015.
 */
public class EHR_pat {

    FHIR_Pat[] patientRecord;

    public FHIR_Pat[] pullPatientData(){

        // API to EHR Database
        int[] MRNs = {1, 2, 3};
        String[] patients = {"John Hurt", "John Doe", "Jane Doe"};
        int[] rooms = {201, 202, 205};
        String[] providers = {"Dr. Young", "Dr. Young", "Dr. Young"};
        String[] dobs = {"Jun 21, 1992", "Jul 28, 1991", "Mar 2, 1990"};
        String[][] allergy = {{"Codeine", "Penicillin", "Peanuts"},{"None"},{"None"}};

        patientRecord = new FHIR_Pat[patients.length];
        for(int i = 0; i < patients.length;i++){
            patientRecord[i].setMRN(MRNs[i]);
            patientRecord[i].setName(patients[i]);
            patientRecord[i].setRoom(rooms[i]);
            patientRecord[i].setProvider(providers[i]);
            patientRecord[i].setDob(dobs[i]);
            patientRecord[i].setAllergies(allergy[i]);

        }
        return patientRecord;
    }
}
