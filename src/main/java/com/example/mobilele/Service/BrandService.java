package com.example.mobilele.Service;

import com.example.mobilele.Model.view.BrandViewModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BrandService {
    List<BrandViewModel> getAllBrands();
}
