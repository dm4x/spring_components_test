package com.kiselyov.components.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="responsibles")
public class Responsible {

    @Id
    @Column(name="id")
    @ApiModelProperty(notes = "The database generated responsible ID", allowEmptyValue = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int responsibleId;

    @ApiModelProperty(notes = "Responsible's name", allowEmptyValue = false)
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
