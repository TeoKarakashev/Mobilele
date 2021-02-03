package com.example.mobilele.Model.Entities;

import com.example.mobilele.Model.Enums.Category;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(length = 512)
    private String imageUrl;
    @Column
    private int startYear;
    @Column
    private Integer endYear;
    @ManyToOne
    private BrandEntity brandEntity;

    @OneToMany(mappedBy = "modelEntity")
    private Set<OfferEntity> offerEntities;

    public ModelEntity() {
    }


    public Set<OfferEntity> getOffers() {
        return offerEntities;
    }

    public void setOffers(Set<OfferEntity> offerEntities) {
        this.offerEntities = offerEntities;
    }


    public BrandEntity getBrand() {
        return brandEntity;
    }

    public void setBrand(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }


    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }


}
