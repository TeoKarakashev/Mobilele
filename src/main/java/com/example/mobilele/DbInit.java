package com.example.mobilele;

import com.example.mobilele.Model.Entities.*;
import com.example.mobilele.Model.Enums.Category;
import com.example.mobilele.Model.Enums.Engine;
import com.example.mobilele.Model.Enums.Role;
import com.example.mobilele.Model.Enums.Transmission;
import com.example.mobilele.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DbInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public DbInit(ModelRepository modelRepository, BrandRepository brandRepository,
                  OfferRepository offerRepository, PasswordEncoder passwordEncoder,
                  UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       // intModelsAndBrands();
       // initOffer(modelRepository.getOne(1L));
       // initUsers();
    }


    private void initOffer(ModelEntity modelEntity) {
        OfferEntity fiestaOffer = new OfferEntity();
        fiestaOffer.setEngine(Engine.DIESEL);

        fiestaOffer.setImageUrl("https://images.unsplash.com/photo-1552519507-da3b142c6e3d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8Mnx8Y2Fyc3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80");
        fiestaOffer.setMileage(80000);
        fiestaOffer.setPrice(BigDecimal.valueOf(10000));
        fiestaOffer.setYear(2017);
        fiestaOffer.setDescription("Garaj e karana ot nemsko babe, koeto e staro.");
        fiestaOffer.setTransmission(Transmission.AUTOMATIC);
        fiestaOffer.setModel(modelEntity);
        offerRepository.save(fiestaOffer);
    }

    private void initUsers() {

        UserRoleEntity adminRole = new UserRoleEntity();
        adminRole.setRole(Role.Admin);
        UserRoleEntity userRole = new UserRoleEntity();
        userRole.setRole(Role.User);
        userRoleRepository.saveAll(List.of(adminRole, userRole));


        UserEntity admin = new UserEntity();
        admin.setFirstName("Bojo");
        admin.setLastName("admin");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("password"));

        admin.setUserRoles(List.of(adminRole, userRole));

        UserEntity user = new UserEntity();
        user.setFirstName("Valio");
        user.setLastName("Jojo");
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("password"));

        user.setUserRoles(List.of(userRole));
        userRepository.saveAll(List.of(admin, user));

    }


    private void intModelsAndBrands() {
        BrandEntity fordBrandEntity = new BrandEntity();
        fordBrandEntity.setName("Ford");
        brandRepository.save(fordBrandEntity);

        BrandEntity audiBrandEntity = new BrandEntity();
        audiBrandEntity.setName("Audi");
        brandRepository.save(audiBrandEntity);

        BrandEntity bmwBrandEntity = new BrandEntity();
        bmwBrandEntity.setName("BMW");
        brandRepository.saveAndFlush(bmwBrandEntity);



        ModelEntity fiesta = new ModelEntity();
        fiesta.setName("Fiesta");
        fiesta.setCategory(Category.Car);
        fiesta.setImageUrl("https://www.carmag.co.za/upload/articles/2020/06/fiesta-48v.jpg");
        fiesta.setStartYear(1976);
        fiesta.setBrand(fordBrandEntity);
        modelRepository.save(fiesta);

        ModelEntity bmw6Series = new ModelEntity();
        bmw6Series.setName("BMW 6 Series");
        bmw6Series.setCategory(Category.Car);
        bmw6Series.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/c/c5/2018_BMW_6er_Gran_Coupe_M_Sport%2C_F06.jpg");
        bmw6Series.setStartYear(2011);
        bmw6Series.setEndYear(2018);
        bmw6Series.setBrand(bmwBrandEntity);
        modelRepository.save(bmw6Series);


        ModelEntity audi = new ModelEntity();
        audi.setName("A8");
        audi.setCategory(Category.Car);
        audi.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/Audi_A8L_60_TFSIe_Quattro_1Y7A5436.jpg/800px-Audi_A8L_60_TFSIe_Quattro_1Y7A5436.jpg");
        audi.setStartYear(1994);
        audi.setBrand(audiBrandEntity);
        modelRepository.save(audi);

        ModelEntity mustang = new ModelEntity();
        mustang.setName("Mustang");
        mustang.setCategory(Category.Car);
        mustang.setImageUrl("https://smartcdn.prod.postmedia.digital/driving/wp-content/uploads/2020/04/chrome-image-407833.png");
        mustang.setStartYear(1964);
        mustang.setBrand(fordBrandEntity);
        modelRepository.save(mustang);
    }


}
