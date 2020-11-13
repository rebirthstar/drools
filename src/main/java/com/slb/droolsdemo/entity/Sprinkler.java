package com.slb.droolsdemo.entity;

public class Sprinkler {
    private Room room;
    private boolean on;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public Sprinkler(Room room, boolean on) {
        this.room = room;
        this.on = on;
    }

    public Sprinkler(Room room) {
        this.room = room;
    }
    // Getter and setter methods
}