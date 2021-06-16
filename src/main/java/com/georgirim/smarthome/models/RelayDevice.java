package com.georgirim.smarthome.models;

import javax.persistence.Entity;

@Entity
public class RelayDevice extends Device{

    private boolean state = false;

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getState(){
        return this.state;
    }
}
