package com.example.internshala.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;


public class Ship {

    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private int weight;
    private String comment;
    private UUID shipperId;
    private Date date;

    //--------------------------------------

    //--------------------------------------

    public String getLoadingPoint() {
        return loadingPoint;
    }


    public String getUnloadingPoint() {
        return unloadingPoint;
    }


    public String getProductType() {
        return productType;
    }


    public String getTruckType() {
        return truckType;
    }


    public int getNoOfTrucks() {
        return noOfTrucks;
    }


    public int getWeight() {
        return weight;
    }


    public String getComment() {
        return comment;
    }


    public UUID getShipperId() {
        return shipperId;
    }


    public Date getDate() {
        return date;
    }


    public Ship(@JsonProperty("loadingPoint") String loadingPoint,
                @JsonProperty("unloadingPoint") String unloadingPoint,
                @JsonProperty("productType") String productType,
                @JsonProperty("truckType") String truckType,
                @JsonProperty("noOfTrucks") int noOfTrucks,
                @JsonProperty("weight") int weight,
                @JsonProperty("comment") String comment,
                @JsonProperty("shipperId") UUID shipperId,
                @JsonProperty("Date") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") Date date) {
        this.loadingPoint = loadingPoint;
        this.unloadingPoint = unloadingPoint;
        this.productType = productType;
        this.truckType = truckType;
        this.noOfTrucks = noOfTrucks;
        this.weight = weight;
        this.comment = comment;
        this.shipperId = shipperId;
        this.date=date;



    }
}
