package com.example.mobilele.Service.impl;

import com.example.mobilele.Model.Entities.OfferEntity;
import com.example.mobilele.Model.service.OfferServiceModel;
import com.example.mobilele.Model.view.OfferSummaryViewModel;
import com.example.mobilele.Service.OfferService;
import com.example.mobilele.repositories.ModelRepository;
import com.example.mobilele.repositories.OfferRepository;
import com.example.mobilele.repositories.UserRepository;
import com.example.mobilele.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final CurrentUser currentUser;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(CurrentUser currentUser, OfferRepository offerRepository,
                            UserRepository userRepository, ModelRepository modelRepository,
                            ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
        return null;
    }

    @Override
    public long save(OfferServiceModel model) {
        OfferEntity offerEntity = asNewEntity(model);
        OfferEntity newEntity = offerRepository.save(offerEntity);
        return newEntity.getId();
    }


    private OfferEntity asNewEntity(OfferServiceModel model){
        OfferEntity offerEntity = new OfferEntity();
        modelMapper.map(model, offerEntity);
        offerEntity.setModel(modelRepository.findById(model.getModelId()).orElseThrow());
        offerEntity.setUserEntity(userRepository.findByUsername(currentUser.getName()).orElseThrow());
        return offerEntity;
    }
}
