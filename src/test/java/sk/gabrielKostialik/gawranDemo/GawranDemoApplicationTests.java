package sk.gabrielKostialik.gawranDemo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import sk.gabrielKostialik.gawranDemo.mapper.AnimalCategoryMapper;
import sk.gabrielKostialik.gawranDemo.mapper.ProductMapper;
import sk.gabrielKostialik.gawranDemo.model.AnimalCategory;
import sk.gabrielKostialik.gawranDemo.model.Product;
import sk.gabrielKostialik.gawranDemo.model.dto.AnimalCategoryDto;
import sk.gabrielKostialik.gawranDemo.model.dto.ProductDto;
import sk.gabrielKostialik.gawranDemo.repository.AnimalCategoryRepository;
import sk.gabrielKostialik.gawranDemo.service.api.AnimalCategoryService;
import sk.gabrielKostialik.gawranDemo.service.api.ProductService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class GawranDemoApplicationTests {

	@Autowired
	AnimalCategoryRepository animalCategoryRepository;

	@Autowired
	AnimalCategoryService animalCategoryService;

	@Autowired
	ProductService productService;

	@Test
	void DbInsertTest() {
		AnimalCategory cats = new AnimalCategory("cats");
		animalCategoryRepository.save(cats);

		AnimalCategory animalCategory = animalCategoryRepository.findByName("cats");

		Assert.assertEquals(animalCategory.getName(), cats.getName());
		Assert.assertEquals(animalCategory, cats);
	}

	@Test
	void serviceTest() {
		AnimalCategory dogs = new AnimalCategory("dogs");

		animalCategoryService.addAnimalCategory(dogs);

		List<AnimalCategoryDto> animalCategories = animalCategoryService.getAll();

		Assert.assertEquals(1, animalCategories.size());
		Assert.assertEquals(animalCategories.get(0).getName(), dogs.getName());
	}

	@Test
	void mapperTest() {
		AnimalCategory dogs = new AnimalCategory("dogs");
		AnimalCategoryDto animalCategoryDto = AnimalCategoryMapper.INSTANCE.animalCategoryToDto(dogs);

		Assert.assertEquals(dogs.getName(), animalCategoryDto.getName());
	}

	@Test
	void intTest() {
		AnimalCategory dogs = new AnimalCategory("dogs");

		ArrayList<String> gallery = new ArrayList<>();
		gallery.add("https://www.helada.sk/images/stories/virtuemart/product/resized/kost_byvolia_800x600.jpg");

		Product product = new Product("Kosť", dogs, 10, "Gumenna kost", gallery);
		productService.addProduct(product);

		List<ProductDto> productDtos = productService.getAll();

		Assert.assertEquals(productDtos.size(), 1);
		Assert.assertEquals(ProductMapper.INSTANCE.productToDto(product).getAnimalCategory(), productDtos.get(0).getAnimalCategory());
	}

}
