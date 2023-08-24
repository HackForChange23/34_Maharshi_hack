package com.hasslewithnans.hack;

public class data {

//    private String place;
    private String district;
    private String mandal;
    private String village;
    private String survey_no;
    private String khata_no;
    private String cost;
    private String area;
    private String ph_no;
    private String watersource;
//    private String croprot;
//    private String negotiation;
//    private String installations;
//    private String years;
    private String soiltype;

    public data(String district,String mandal, String village, String survey_no, String khata_no, String cost, String area, String ph_no, String soiltype, String watersource){
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
        this.cost = cost;
        this.area = area;
        this.ph_no = ph_no;
        this.watersource = watersource;
        this.soiltype = soiltype;

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
    public String getCost() {
        return cost;
    }
    public String getArea() {
        return  area;
    }
    public String getPh_no() {
        return ph_no;
    }
    public String getSoil() {
        return soiltype;
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


