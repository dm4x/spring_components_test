package com.dm4x.components.entity;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="components")
public class Component {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int componentId;

    @Column(name="name")
    @NotNull
    String name;

    @Column(name="creation_date")
    @NotNull
    String creation_date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="responsible_id")
    private Responsible responsible;

    public Component(){}

    Component(String name, String creation_date){
        this.name = name;
        this.creation_date = creation_date;
    }

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

}
