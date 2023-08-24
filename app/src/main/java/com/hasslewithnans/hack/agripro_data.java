package com.hasslewithnans.hack;

public class agripro_data {

//    private String place;
    private String item;
    private String phone_num;
    private String buyrent;
    private String description;
    private String quantity;
    private String cost;


    public agripro_data(String item, String ph_no, String buyrent, String description, String quantity, String cost){
//        this.place = place;
//        this.years = years;
//        this.croprot = rotations;
//        this.installations = installations;
//        this.negotiation = negotiation;
        this.item = item;
        this.phone_num = ph_no;
        this.buyrent = buyrent;
        this.description = description;
        this.quantity = quantity;
        this.cost = cost;

    }

    public String getItem() {
        return item;
    }
    public String getPhone_num() {
        return phone_num;
    }
    public String getBuyrent() {
        return buyrent;
    }
    public String getDescription() {
        return description;
    }
    public String getQuantity() {
        return quantity;
    }
    public String getCost() { return cost; }

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


