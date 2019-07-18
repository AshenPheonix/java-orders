package com.brandonporter.orders2.models;

import javax.persistence.*;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    private double  ordamount,
                    advanceamount;

    private String orddescripion;

    @OneToMany
    @JoinColumn(name = "custcode",
                nullable = false)
    private Customer customer;

    public Order() {}

    public Order(double ordamount, double advanceamount, Customer customer, String orddescripion) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orddescripion = orddescripion;
        this.customer = customer;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrddescripion() {
        return orddescripion;
    }

    public void setOrddescripion(String orddescripion) {
        this.orddescripion = orddescripion;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
