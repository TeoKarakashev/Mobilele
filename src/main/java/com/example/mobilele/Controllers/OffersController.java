package com.example.mobilele.Controllers;

import com.example.mobilele.Model.Enums.Engine;
import com.example.mobilele.Model.Enums.Transmission;
import com.example.mobilele.Model.service.OfferServiceModel;
import com.example.mobilele.Model.service.UserLoginServiceModel;
import com.example.mobilele.Service.BrandService;
import com.example.mobilele.Service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;
    private final BrandService brandService;

    @Autowired
    public OffersController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute("offerModel")
    public OfferServiceModel offerModel() {
        return new OfferServiceModel();
    }

    @GetMapping("/all")
    public String getAllOffers(Model model) {
        model.addAttribute("models", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/add")
    public String addOffer(Model model){
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOfferConfirm(@Valid @ModelAttribute OfferServiceModel offerModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);
            return "redirect:/offers/add";
        }
        offerService.save(offerModel);
        return "redirect:/";
    }


}
