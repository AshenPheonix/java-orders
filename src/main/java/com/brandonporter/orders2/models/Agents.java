package com.brandonporter.orders2.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name="Agents")
public class Agents {
    private static AtomicLong counter=new AtomicLong(1);


    private final long agentCode;

    private String  agentname,
                    workingarea,
                    phone,
                    country;

    private double commission;

    public Agents(String agentname, String workingarea, String phone, String country, double commission) {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.phone = phone;
        this.country = country;
        this.commission = commission;

        agentCode=counter.longValue();
        counter.incrementAndGet();
    }

    public long getAgentCode() {
        return agentCode;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
}