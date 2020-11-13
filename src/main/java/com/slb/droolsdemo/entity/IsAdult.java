package com.slb.droolsdemo.entity;

public class IsAdult {
    private Person person;

    public IsAdult(Person person){
        this.person=person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
