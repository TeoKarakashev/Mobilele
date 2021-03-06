package com.example.mobilele.Service;

import com.example.mobilele.Model.service.OfferServiceModel;
import com.example.mobilele.Model.view.OfferSummaryViewModel;

import java.util.List;

public interface OfferService {

    List<OfferSummaryViewModel> getAllOffers();

    long save(OfferServiceModel offerServiceModel);
}
