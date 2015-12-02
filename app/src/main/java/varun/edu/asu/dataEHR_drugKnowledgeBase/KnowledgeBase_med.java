package varun.edu.asu.dataEHR_drugKnowledgeBase;

import varun.edu.asu.datamodels.FHIR_Med;

/**
 * Created by Varun on 12/1/2015.
 */
public class KnowledgeBase_med {

    FHIR_Med[] medRecord;
    public FHIR_Med[] pullMedAdminInfo(){
        //Log.w("myApp", "1");
        // API to RxNorm Knowledge Base
        String[] drugs = {"Acetaminophen", "Warfarin", "Lisinopril"};
        String[] NDC = {"0100301210657115", "202", "205"};
        int[] dose= {10, 2,10};
        String[] doseUnits = {"ml","mg","mg"};
        String[] routeAdmin ={"Oral", "Oral", "Oral"};
        String[] packaging = {"Solution","Tablet", "Tablet"};

        medRecord = new FHIR_Med[NDC.length];
        for(int i = 0; i < NDC.length;i++){
            medRecord[i] = new FHIR_Med();
            medRecord[i].setName(drugs[i]);
            medRecord[i].setNDC(NDC[i]);
            medRecord[i].setDose(dose[i]);
            medRecord[i].setDoseUnits(doseUnits[i]);
            medRecord[i].setRouteOfAdmin(routeAdmin[i]);
            medRecord[i].setPackaging(packaging[i]);
        }
        return medRecord;
    }
}
