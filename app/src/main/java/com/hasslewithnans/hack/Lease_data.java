package com.hasslewithnans.hack;

public class Lease_data {

    //    private String place;
    private String district;
    private String mandal;
    private String village;
    private String survey_no;
    private String khata_no;
    private String neg;
    private String area;
    private String ph_no;
    private String watersource;
    //    private String croprot;
//    private String negotiation;
//    private String installations;
//    private String years;

    public Lease_data(String district,String mandal, String village, String survey_no, String khata_no, String neg, String area, String ph_no, String watersource){
//        this.place = place;
//        this.years = years;
//        this.croprot = rotations;
//        this.installations = installations;
//        this.negotiation = negotiation;
        this.district = district;
        this.mandal = mandal;
        this.village = village;
        this.survey_no = survey_no;
        this.khata_no = khata_no;
        this.neg = neg;
        this.area = area;
        this.ph_no = ph_no;
        this.watersource = watersource;

    }

    public String getDistrict() {
        return district;
    }
    public String getMandal() {
        return mandal;
    }
    public String getVillage() {
        return village;
    }
    public String getSurvey_no() {
        return survey_no;
    }
    public String getKhata_no() {
        return khata_no;
    }
    public String getNeg() {
        return neg;
    }
    public String getArea() {
        return  area;
    }
    public String getPh_no() {
        return ph_no;
    }
    public String getWatersource() {
        return watersource;
    }
//    public String getPlace() {
//        return place;
//    }
//    public String getRot() {
//        return croprot;
//    }
//    public String getNegotiation() {
//        return negotiation;
//    }
//    public String getInstallations() {
//        return installations;
//    }
//    public String getYears() {
//        return years;
//    }

}


