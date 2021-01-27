package com.example.mobilele.Model.Entities;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "brandEntity", fetch = FetchType.EAGER)
    private Set<ModelEntity> modelEntities;

    public BrandEntity() {
    }

    public Set<ModelEntity> getModels() {
        return modelEntities;
    }

    public void setModels(Set<ModelEntity> modelEntities) {
        this.modelEntities = modelEntities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
