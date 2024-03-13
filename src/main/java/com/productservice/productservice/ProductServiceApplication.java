package com.productservice.productservice;


import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Order;
import com.productservice.productservice.models.Price;

import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.OrderRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final PriceRepository priceRepository;
	private final OrderRepository orderRepository;

	public ProductServiceApplication(CategoryRepository categoryRepository,
									 ProductRepository productRepository,
									 PriceRepository priceRepository,
									 OrderRepository orderRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.priceRepository = priceRepository;
		this.orderRepository = orderRepository;
	}

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
//		Price savedPrice = priceRepository.save(price);
//
//		Category category = new Category();
//		category.setName("Apple devices");
//
//		Category savedCategory = categoryRepository.save(category);
//
//		Product product = new Product();
//		product.setCategory(savedCategory);
//		product.setPrice(savedPrice);
//		product.setTitle("Iphone 15 pro");
//		product.setDescription("Best Iphone");
//		Product savedProduct = productRepository.save(product);
//
//
//		Order  order = new Order();
//		orderRepository.save(order);


		priceRepository.deleteById(UUID.fromString("d79e611c-1b88-4ba2-869f-0e98165b82f0"));

	}
}
