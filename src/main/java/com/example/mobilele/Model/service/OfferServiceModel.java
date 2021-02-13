package com.example.mobilele.Model.service;

import com.example.mobilele.Model.Enums.Engine;
import com.example.mobilele.Model.Enums.Transmission;
import com.example.mobilele.Model.Validation.YearInPastOrPresent;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OfferServiceModel {

    @NotEmpty
    @Size(min = 10)
    private String description;

    @NotNull
    private Engine engine;

    @NotNull
    private String imageUrl;

    @NotNull
    @Positive
    private Integer mileage;

    @DecimalMin("100")
    private BigDecimal price;

    @NotNull
    private Transmission transmission;

    @YearInPastOrPresent(minYear = 1930)
    private Integer year;

    @NotNull
    private Long modelId;

    public OfferServiceModel() {
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

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    @Override
    public String toString() {
        return "OfferServiceModel{" +
                "description='" + description + '\'' +
                ", engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", modelId=" + modelId +
                '}';
    }
}
