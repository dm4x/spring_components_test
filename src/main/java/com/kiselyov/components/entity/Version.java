package com.kiselyov.components.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="versions")
public class Version {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated version ID", allowEmptyValue = false)
    int versionId;

    @Column(name = "name")
    @ApiModelProperty(notes = "Version's number/name", allowEmptyValue = false)
    String name;

    @Column(name="creation_date")
    @ApiModelProperty(notes = "Creation date of this version", allowEmptyValue = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime creationDate;

    @ApiModelProperty(notes = "Responsible for this version", allowEmptyValue = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="responsible_id")
    private Responsible responsible;

    Version(){
    }

    Version(String name, LocalDateTime creationDate){
        this.name = name;
        this.creationDate = creationDate;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }
}
