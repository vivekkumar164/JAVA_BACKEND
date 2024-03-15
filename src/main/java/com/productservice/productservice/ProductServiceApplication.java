package com.productservice.productservice;


import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Order;
import com.productservice.productservice.models.Price;

import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.OrderRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final PriceRepository priceRepository;

	public ProductServiceApplication(CategoryRepository categoryRepository,
									 ProductRepository productRepository,
									 PriceRepository priceRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.priceRepository = priceRepository;
	}

//	private final CategoryRepository categoryRepository;
//	private final ProductRepository productRepository;
//	private final PriceRepository priceRepository;
//	private final OrderRepository orderRepository;
//
//	public ProductServiceApplication(CategoryRepository categoryRepository,
//									 ProductRepository productRepository,
//									 PriceRepository priceRepository,
//									 OrderRepository orderRepository) {
//		this.categoryRepository = categoryRepository;
//		this.productRepository = productRepository;
//		this.priceRepository = priceRepository;
//		this.orderRepository = orderRepository;
//	}

//	private UserRepository userRepository;
//	private StudentRepository studentRepository;
//	private MentorRepository mentorRepository;
////
//	ProductServiceApplication(
//			@Qualifier("st_userrepository") UserRepository userRepository,
//			@Qualifier("st_mentor") MentorRepository mentorRepository,
//			@Qualifier("st_student") StudentRepository studentRepository
//
//			){
//		this.userRepository=userRepository;
//		this.mentorRepository=mentorRepository;
//		this.studentRepository=studentRepository;
//
//
//	}

//	private MentorRepository mentorRepository;
//	private StudentRepository studentRepository;
//	private TaRepository taRepository;
//	private UserRepository userRepository;
//
//	ProductServiceApplication(
//			@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository,
//			StudentRepository studentRepository,
//			TaRepository taRepository,
//			UserRepository userRepository
//			){
//		this.mentorRepository = mentorRepository;
//		this.studentRepository = studentRepository;
//		this.taRepository = taRepository;
//		this.userRepository = userRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	@Transactional()
	public void run(String... args) throws Exception {
//		Mentor mentor = new Mentor();
//		mentor.setName("Deepak");
//		mentor.setEmail("deepak.kasera@scaler.com");
//		mentor.setAvgRating(4.1);
//
//		mentorRepository.save(mentor);
//
//		Student student = new Student();
//		student.setPsp(99.0);
//		student.setEmail("vivek123@gmail.com");
//		student.setName("vivek kumar");
//
//		studentRepository.save(student);
//
//		Ta ta = new Ta();
//		ta.setEmail("abc@gmail.com");
//		ta.setTa_session("morning");
//		ta.setName("Sarthak khurana");
//		taRepository.save(ta);
//
//		User user = new User();
//		user.setEmail("user@gmail.com");
//		user.setName("user");
//
//		userRepository.save(user);
//
//		List<User> users = userRepository.findAll();
//		for(User user1: users){
//			System.out.println(user1.toString());
//		}

//		User user = new User();
//		user.setEmail("test@gmail.com");
//		user.setName("test");
//
//		userRepository.save(user);
//
//		Student student = new Student();
//		student.setPsp(88.9);
//		student.setEmail("student@gmail.com");
//		student.setName("student");
//
//		studentRepository.save(student);
//
//		Mentor mentor = new Mentor();
//		mentor.setAvgRating(9);
//		mentor.setEmail("mentor@gmail.com");
//		mentor.setName("mentor");
//
//		mentorRepository.save(mentor);

//		Category category = new Category();
//		category.setName("Apple Devices");
//
//		Category savedCategory = categoryRepository.save(category);
//		Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("0a2b3350-013e-42e7-aeb7-437175491d2e"));
//		if(optionalCategory.isEmpty()){
//			throw new Exception("Category was null:");
//		}
//		Category category = optionalCategory.get();
//		Product product = new Product();
//		product.setTitle("iPhone 15 pro");
//		product.setDescription("Best product");
//		product.setCategory(category.get());
//
//		Product savedProduct = productRepository.save(product);

		//Find all products with  category = apple
//		List<Product> products = category.getProducts();
//		for(Product product : products){
//			System.out.println(product.getTitle());
//		}

//		Price price = new Price();
//		price.setCurrency("INR");
//		price.setValue(100000);
//
//		//Price savedPrice = priceRepository.save(price);
//
//		Category category = new Category();
//		category.setName("Apple devices");
//
//		Category savedCategory = categoryRepository.save(category);
//
//		Product product = new Product();
//		product.setCategory(savedCategory);
//		product.setPrice(price);
//		product.setTitle("Iphone 15 pro");
//		product.setDescription("Best Iphone");
//		Product savedProduct = productRepository.save(product);

		//productRepository.deleteById(UUID.fromString("c371f0de-3187-4035-afbf-c421625ef82b"));

//		Category category = new Category();
//		category.setName("Apple Device");
//		Category savedCategory = categoryRepository.save(category);
//
//		Price price1 = new Price();
//		price1.setValue(100000);
//		price1.setCurrency("INR");
//
//		Product product1 = new Product();
//		product1.setPrice(price1);
//		product1.setTitle("iPhone1");
//		product1.setDescription("iphone 14c max");
//		product1.setCategory(category);
//		Product savedProduct = productRepository.save(product1);
//
//		Price price2 = new Price();
//		price2.setValue(100000);
//		price2.setCurrency("INR");
//
//
//		Product product2 = new Product();
//		product2.setPrice(price2);
//		product2.setTitle("iPhone2");
//		product2.setDescription("iphone 14c max");
//		product2.setCategory(category);
//		Product savedProduct1 = productRepository.save(product2);
//
//
//		Price price3 = new Price();
//		price3.setValue(100000);
//		price3.setCurrency("INR");
//
//
//		Product product3 = new Product();
//		product3.setPrice(price3);
//		product3.setTitle("iPhone3");
//		product3.setDescription("iphone 15c max");
//		product3.setCategory(category);
//		Product savedProduct3 = productRepository.save(product3);

		Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("670262b1-4895-4795-b985-f857a3531357"));

		if(optionalCategory.isEmpty()){
			throw new Exception("No Category found:");
		}

		Category category = optionalCategory.get();

		List<Product> products = category.getProducts();

		for(Product product : products){
			System.out.println(product.getTitle());
		}


	}
}
