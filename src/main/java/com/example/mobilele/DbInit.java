package com.example.mobilele;

import com.example.mobilele.Model.Entities.BrandEntity;
import com.example.mobilele.Model.Entities.ModelEntity;
import com.example.mobilele.Model.Entities.OfferEntity;
import com.example.mobilele.Model.Enums.Category;
import com.example.mobilele.Model.Enums.Engine;
import com.example.mobilele.Model.Enums.Transmission;
import com.example.mobilele.repositories.BrandRepository;
import com.example.mobilele.repositories.ModelRepository;
import com.example.mobilele.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;

@Component
public class DbInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;

    @Autowired
    public DbInit(ModelRepository modelRepository, BrandRepository brandRepository, OfferRepository offerRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //initializeModelsAndBrands();
       // initailzeOffer(modelRepository.getOne(1L));

    }

    private void initailzeOffer(ModelEntity modelEntity) {
        OfferEntity fiestaOffer = new OfferEntity();
        fiestaOffer.setEngine(Engine.DIESEL);
        fiestaOffer.setCreated(Instant.now());
        fiestaOffer.setModified(Instant.now());
        fiestaOffer.setImageUrl("https://images.unsplash.com/photo-1552519507-da3b142c6e3d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8Mnx8Y2Fyc3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80");
        fiestaOffer.setMileage(80000);
        fiestaOffer.setPrice(BigDecimal.valueOf(10000));
        fiestaOffer.setYear(2017);
        fiestaOffer.setDescription("Garaj e karana ot nemsko babe, koeto e staro.");
        fiestaOffer.setTransmission(Transmission.AUTOMATIC);
        fiestaOffer.setModel(modelEntity);
        offerRepository.saveAndFlush(fiestaOffer);
    }


    private void initializeModelsAndBrands(){
        BrandEntity fordBrandEntity = new BrandEntity();
        fordBrandEntity.setName("Ford");
        fordBrandEntity.setCreated(Instant.now());
        fordBrandEntity.setModified(Instant.now());
        BrandEntity hondaBrandEntity = new BrandEntity();
        hondaBrandEntity.setName("Honda");
        hondaBrandEntity.setCreated(Instant.now());
        hondaBrandEntity.setModified(Instant.now());
        brandRepository.saveAndFlush(hondaBrandEntity);
        brandRepository.saveAndFlush(fordBrandEntity);
        ModelEntity fiesta = new ModelEntity();
        fiesta.setName("Fiesta");
        fiesta.setCategory(Category.Car);
        fiesta.setImageUrl("https://images.unsplash.com/photo-1552519507-da3b142c6e3d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8Mnx8Y2Fyc3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80");
        fiesta.setStartYear(1976);
        fiesta.setBrand(hondaBrandEntity);
        fiesta.setCreated(Instant.now());
        fiesta.setBrand(hondaBrandEntity);
        fiesta.setModified(Instant.now());
        modelRepository.saveAndFlush(fiesta);
        ModelEntity escort = new ModelEntity();
        escort.setName("Escort");
        escort.setCategory(Category.Car);
        escort.setCreated(Instant.now());
        escort.setModified(Instant.now());
        escort.setImageUrl("https://images.unsplash.com/photo-1552519507-da3b142c6e3d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8Mnx8Y2Fyc3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80");
        escort.setStartYear(1968);
        escort.setEndYear(2002);
        escort.setBrand(fordBrandEntity);
        modelRepository.saveAndFlush(escort);
    }


}
