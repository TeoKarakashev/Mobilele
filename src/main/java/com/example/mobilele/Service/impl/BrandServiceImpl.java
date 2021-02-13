package com.example.mobilele.Service.impl;

import com.example.mobilele.Model.Entities.BrandEntity;
import com.example.mobilele.Model.Entities.ModelEntity;
import com.example.mobilele.Model.view.BrandViewModel;
import com.example.mobilele.Model.view.ModelViewModel;
import com.example.mobilele.Service.BrandService;
import com.example.mobilele.repositories.BrandRepository;
import com.example.mobilele.repositories.ModelRepository;
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
        List<BrandViewModel> result = new ArrayList<>();// <- final result here

        List<ModelEntity> allModels =
                modelRepository.findAll();

        allModels.forEach(me -> {
            // example: fiesta -> ford
            BrandEntity brandEntity = me.getBrand();

            Optional<BrandViewModel> brandViewModelOpt = findByName(result,
                    brandEntity.getName());
            if (brandViewModelOpt.isEmpty()) {
                // not yet in the result, we will create a new model
                BrandViewModel newBrandViewModel = new BrandViewModel();
                modelMapper.map(brandEntity, newBrandViewModel);
                result.add(newBrandViewModel);
                brandViewModelOpt = Optional.of(newBrandViewModel);
            }

            ModelViewModel newModelViewModel = new ModelViewModel();
            modelMapper.map(me, newModelViewModel);
        });

        return result;
    }



    private static Optional<BrandViewModel> findByName(List<BrandViewModel> allModels, String name) {
        return allModels.stream().filter(m -> m.getName().equals(name)).findAny();
    }
}
