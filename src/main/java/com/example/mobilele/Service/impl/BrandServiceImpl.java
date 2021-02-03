package com.example.mobilele.Service.impl;

import com.example.mobilele.Model.Entities.BrandEntity;
import com.example.mobilele.Model.Entities.ModelEntity;
import com.example.mobilele.Model.view.BrandViewModel;
import com.example.mobilele.Model.view.ModelViewModel;
import com.example.mobilele.Service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public BrandServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        List<ModelEntity> allModelEntities = modelRepository.findAll();
        List<BrandViewModel> brandViewModels = new ArrayList<>();
        allModelEntities.forEach(me -> {
            BrandEntity brandEntity = me.getBrand();
            Optional<BrandViewModel> brandViewModelOpt = findByName(brandViewModels, brandEntity.getName());
            if (!brandViewModelOpt.isPresent()) {
                BrandViewModel newBrandViewModel = new BrandViewModel();
                modelMapper.map(brandEntity, newBrandViewModel);
                brandViewModels.add(newBrandViewModel);
                brandViewModelOpt = Optional.of(newBrandViewModel);
            }

            ModelViewModel newModelViewModel = new ModelViewModel();
            modelMapper.map(me, newModelViewModel);
            brandViewModelOpt.get().addModel(newModelViewModel);
        });


        return brandViewModels;
    }


    private static Optional<BrandViewModel> findByName(List<BrandViewModel> allModels, String name) {
        return allModels.stream().filter(m -> m.getName().equals(name)).findAny();
    }
}
