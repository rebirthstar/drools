package com.slb.droolsdemo.entity;

public class Fire {
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    private Room room;

    public Fire(Room room) {
        this.room = room;
    }

    // Getter and setter methods
}
