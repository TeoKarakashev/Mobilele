package com.example.mobilele.Entities;

import com.example.mobilele.EntitiesEnums.Category;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(length = 512)
    private String imageUrl;
    @Column
    private int startYear;
    @Column
    private int endYear;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @OneToMany(mappedBy = "model")
    private Set<Offer> offers;

    public Model() {
    }


    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }


    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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


    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }


}
