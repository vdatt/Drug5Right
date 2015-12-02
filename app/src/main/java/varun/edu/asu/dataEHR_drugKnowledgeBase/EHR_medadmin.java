package varun.edu.asu.dataEHR_drugKnowledgeBase;
import android.util.Log;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import varun.edu.asu.datamodels.FHIR_MedAdmin;

/**
 * Created by Varun on 11/30/2015.
 */
public class EHR_medadmin {

    String[] MRNs = {"3338356", "2", "3"};
    String[] patients = {"John Hurt", "John Doe", "Jane Doe"};
    int[] rooms = {201, 202, 205};
    String[] providers = {"Dr. Young", "Dr. Young", "Dr. Young"};
    String[] drugs = {"Acetaminophen", "Warfarin", "Lisinopril"};
    String[] NDC = {"0100301210657115", "202", "205"};
    int[] dose= {10, 2,10};
    String[] doseUnits = {"ml","mg","mg"};
    String[] timeDue = {"02/12/2015 08:00AM","02/12/2015 08:30AM","01/12/2015 09:00AM"};
    String[] routeAdmin ={"Oral", "Oral", "Oral"};
    String[] dobs = {"May 5, 1959", "Jul 28, 1991", "Mar 2, 1990"};
    String[][] allergy = {{"Codeine", "Penicillin", "Peanuts"},{"None"},{"None"}};
    String[] packaging = {"Solution","Tablet", "Tablet"};
    String[] providerContact = {"4803764313","4803764313","4803764313"};
    boolean[] complete = {false, false, false};

    FHIR_MedAdmin[] medAdmins;
    public FHIR_MedAdmin[] pullMedAdminInfo(){
        //Log.w("myApp", "1");
        // API to EHR Database
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c.getTime());
        int count =0;
        for(int i = 0; i < patients.length;i++) {
            if (timeDue[i].substring(0, 10).equals(formattedDate))
                count++;
        }
        medAdmins = new FHIR_MedAdmin[count];
        for(int i = 0; i < patients.length;i++){
            if(timeDue[i].substring(0,10).equals(formattedDate)) {
                medAdmins[i] = new FHIR_MedAdmin();
                medAdmins[i].setPatientName(patients[i]);
                medAdmins[i].setPatientMRN(MRNs[i]);
                medAdmins[i].setDrug(drugs[i]);
                medAdmins[i].setNDC(NDC[i]);
                medAdmins[i].setDose(dose[i]);
                medAdmins[i].setDoseUnits(doseUnits[i]);
                medAdmins[i].setRouteOfAdmin(routeAdmin[i]);
                medAdmins[i].setRoom(rooms[i]);
                medAdmins[i].setProvider(providers[i]);
                medAdmins[i].setTimeDue(timeDue[i]);
                medAdmins[i].setDobs(dobs[i]);
                medAdmins[i].setPackaging(packaging[i]);
                medAdmins[i].setAllergy(allergy[i]);
                medAdmins[i].setProviderContact(providerContact[i]);
                medAdmins[i].setComplete(complete[i]);
            }
        }
        return medAdmins;
    }
    public FHIR_MedAdmin getRoomMedAdmin(int room){
        FHIR_MedAdmin medA = new FHIR_MedAdmin();
        FHIR_MedAdmin[] me = pullMedAdminInfo();
        int numberOfRooms =me.length;
        for(int i = 0; i < numberOfRooms;i++){
            if(me[i].getRoom()==room){
                medA = me[i];
                break;
            }
        }
        return medA;
    }

    public FHIR_MedAdmin[] getSortedRoomList(){
        FHIR_MedAdmin medA = new FHIR_MedAdmin();
        FHIR_MedAdmin[] me = pullMedAdminInfo();
        int numberOfRooms =3;
        //SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
        //String time1 = sdf.format(dt);
        for(int i = 0; i < 3;i++){
            medA=me[i];
            String time = medA.getTimeDue().substring(9);
            try {
                DateFormat sdf = new SimpleDateFormat("hh:mm aa");
                Date date = sdf.parse(time);
            }catch (java.text.ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return me;
    }

}
