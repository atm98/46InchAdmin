package com.a46inch.a46inchadmin.m_model;

/**
 * Created by S.H.I.E.L.D on 5/17/2017.
 */

public class Products {
    private String Pname;
    private String Pdesc;
    private String Pprice;
    private String Pseller;
    private String Pid;
    private String Pcatagory;
    private int Pquant;

    public Products() {
        // ...
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getPdesc() {
        return Pdesc;
    }

    public void setPdesc(String pdesc) {
        Pdesc = pdesc;
    }

    public String getPprice() {
        return Pprice;
    }

    public void setPprice(String pprice) {
        Pprice = pprice;
    }

    public String getPseller() {
        return Pseller;
    }

    public void setPseller(String pseller) {
        Pseller = pseller;
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    public String getPcatagory() {
        return Pcatagory;
    }

    public void setPcatagory(String pcatagory) {
        Pcatagory = pcatagory;
    }

    public int getPquant() {
        return Pquant;
    }

    public void setPquant(int pquant) {
        Pquant = pquant;
    }


}