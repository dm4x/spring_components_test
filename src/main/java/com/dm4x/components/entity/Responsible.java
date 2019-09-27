package com.dm4x.components.entity;

import javax.persistence.*;

@Entity
@Table(name="responsibles")
public class Responsible {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int responsibleId;

    @Column(name="name")
    String name;

    // define constructors
    public Responsible() {}

    public Responsible(String name) {
        this.name = name;
    }

    public int getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(int responsibleId) {
        this.responsibleId = responsibleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Responsible{" +
                "id=" + responsibleId +
                ", Name='" + name + '\'' +
                '}';
    }
}
