package com.example.mobilele.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    private Set<Model> models;

    public Brand() {
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
