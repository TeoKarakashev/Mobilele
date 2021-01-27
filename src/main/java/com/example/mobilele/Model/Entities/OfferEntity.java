package com.example.mobilele.Model.Entities;

import com.example.mobilele.Model.Enums.Engine;
import com.example.mobilele.Model.Enums.Transmission;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @Column
    private String description;
    @Enumerated(EnumType.STRING)
    private Engine engine;
    @Column(name = "image_url")
    private String imageUrl;
    @Column
    private int mileage;
    @Column
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    private int year;

    // @ManyToOne
    // @JoinColumn(name = "seller_id")
    // private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelEntity modelEntity;

    public OfferEntity() {
    }


    //  public UserEntity getUser() {
    //  return userEntity;
    //  }

    // public void setUser(UserEntity userEntity) {
    //    this.userEntity = userEntity;
    //  }

    public ModelEntity getModel() {
        return modelEntity;
    }

    public void setModel(ModelEntity modelEntity) {
        this.modelEntity = modelEntity;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
