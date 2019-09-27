package com.dm4x.components.entity;

import javax.persistence.*;

@Entity
@Table(name="versions")
public class Version {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int versionId;

    @Column(name = "name")
    String name;

    @Column(name="creation_date")
    String creationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="responsible_id")
    private Responsible responsible;

    Version(){
    }

    Version(String name, String creationDate){
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }
}
