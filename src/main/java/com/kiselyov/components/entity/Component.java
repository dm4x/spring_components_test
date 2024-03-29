package com.kiselyov.components.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="components")
public class Component {

    @Id
    @Column(name="id")
    @ApiModelProperty(notes = "The database generated component ID", allowEmptyValue = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int componentId;

    @ApiModelProperty(notes = "Component's name", allowEmptyValue = false)
    @Column(name="name")
    @NotNull
    String name;

    @ApiModelProperty(notes = "Component's creation date", allowEmptyValue = false)
    @Column(name="creation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    LocalDateTime creation_date;

    @ApiModelProperty(notes = "Responsible for this version of component", allowEmptyValue = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="responsible_id")
    private Responsible responsible;

    public Component(){}

    Component(String name, LocalDateTime creation_date){
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

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

}
