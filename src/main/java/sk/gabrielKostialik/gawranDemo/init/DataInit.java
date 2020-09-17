package sk.gabrielKostialik.gawranDemo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sk.gabrielKostialik.gawranDemo.model.AnimalCategory;
import sk.gabrielKostialik.gawranDemo.model.Product;
import sk.gabrielKostialik.gawranDemo.repository.ProductRepository;
import sk.gabrielKostialik.gawranDemo.service.api.AnimalCategoryService;
import sk.gabrielKostialik.gawranDemo.service.api.ProductService;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataInit implements ApplicationListener<ContextRefreshedEvent> {
    AnimalCategoryService animalCategoryService;
    ProductService productService;

    public DataInit(AnimalCategoryService animalCategoryService, ProductService productService) {
        this.animalCategoryService = animalCategoryService;
        this.productService = productService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
       /* AnimalCategory cats = new AnimalCategory("cats");
        animalCategoryService.addAnimalCategory(cats);

        AnimalCategory dogs = new AnimalCategory("dogs");
        animalCategoryService.addAnimalCategory(dogs);

        AnimalCategory animalCategory = new AnimalCategory("others");
        animalCategoryService.addAnimalCategory(animalCategory);

        ArrayList<String> gallery = new ArrayList<>();
        gallery.add("https://www.helada.sk/images/stories/virtuemart/product/resized/kost_byvolia_800x600.jpg");

        gallery.add("https://images.obi.sk/product/SK/412x329/106707_1.jpg");

        System.out.println(gallery.size());

        Product product = new Product("Kosť", dogs, 10, "Gumenna kost", gallery);
        productService.addProduct(product);

        gallery = new ArrayList<>();
        gallery.add("https://abc-zoo.sk/9357-17003-thickbox/bavlnene-lano-s-uzlami-hracka-pre-psa-22-cm.jpg");

        gallery.add("https://www.queedo.sk/wp-content/uploads/2019/12/Hracka-pre-psa-lano-uzol-zlta-queedo-sk.jpg");

        Product product1 = new Product("Lano", dogs, 20, "Riadne lano", gallery);
        productService.addProduct(product1);

        gallery = new ArrayList<>();
        gallery.add("http://www.granule-krmivo.sk/core/components/com_shop/image.php?fileName=TXEHPM6.png&width=800");

        gallery.add("https://i00.eu/img/543/1024x1024/bw2lkbqu/53098.webp");

        Product product2 = new Product("Myš", cats, 6, "Rychla mys", gallery);
        productService.addProduct(product2);

        product2 = new Product("Lanko", cats, 8, "Lanko pre macku", gallery);
        productService.addProduct(product2);

        product2 = new Product("Granule", cats, 40, "Whiskas", gallery);
        productService.addProduct(product2);

        product2 = new Product("Granule2", cats, 43, "Pedigree", gallery);
        productService.addProduct(product2);*/
    }
}
