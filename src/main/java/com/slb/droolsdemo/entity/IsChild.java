package com.slb.droolsdemo.entity;

public class IsChild {
    private Person person;

    public IsChild(Person person){
        this.person=person;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
