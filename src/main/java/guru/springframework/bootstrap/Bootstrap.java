package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count().block() == 0){
            //load data
            System.out.println("#### LOADING CATEGORY DATA ON BOOTSTRAP ####");

            categoryRepository.save(Category.builder()
                        .description("Fruits").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Nuts").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Breads").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Meats").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Eggs").build()).block();

            System.out.println("Loaded Categories: " + categoryRepository.count().block());
        }

        if (vendorRepository.count().block() == 0){
            System.out.println("#### LOADING VENDOR DATA ON BOOTSTRAP ####");

            vendorRepository.save(Vendor.builder()
                    .firstName("Jimmy")
                    .lastName("McGill").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstName("Gustavo")
                    .lastName("Fring").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstName("Kim")
                    .lastName("Wexler").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstName("Mike")
                    .lastName("Ehrmantraut").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstName("Howard")
                    .lastName("Hamlin").build()).block();

            System.out.println("Loaded Vendors: " + vendorRepository.count().block());
        }
    }
}
