package com.productservice.productservice;


import com.productservice.productservice.inheritanceRelations.singleTable.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private UserRepository userRepository;
	private StudentRepository studentRepository;
	private MentorRepository mentorRepository;
//
	ProductServiceApplication(
			@Qualifier("st_userrepository") UserRepository userRepository,
			@Qualifier("st_mentor") MentorRepository mentorRepository,
			@Qualifier("st_student") StudentRepository studentRepository

			){
		this.userRepository=userRepository;
		this.mentorRepository=mentorRepository;
		this.studentRepository=studentRepository;


	}

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

		User user = new User();
		user.setEmail("test@gmail.com");
		user.setName("test");

		userRepository.save(user);

		Student student = new Student();
		student.setPsp(88.9);
		student.setEmail("student@gmail.com");
		student.setName("student");

		studentRepository.save(student);

		Mentor mentor = new Mentor();
		mentor.setAvgRating(9);
		mentor.setEmail("mentor@gmail.com");
		mentor.setName("mentor");

		mentorRepository.save(mentor);


	}
}
