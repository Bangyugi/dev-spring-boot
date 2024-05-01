package com.bangvan.cruddemo;

import com.bangvan.cruddemo.dao.AppDAO;
import com.bangvan.cruddemo.entity.Instructor;
import com.bangvan.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id=6;
		System.out.println("Deleting Instructor detail id: " + id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done!!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id=1;
		System.out.println("Finding Instructor detail id: " + id);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Instructor detail is: " + instructorDetail);
		System.out.println("The associated instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 4;
		System.out.println("Deleting instructor id: " + id);
		appDAO.deleteInstructorByID(id);
		System.out.println("Done!!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 4;
		System.out.println("Finding instructor id: "+ id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor is: "+ instructor);
		System.out.println("the associated instructorDetail only: "+ instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		// create instructor
		Instructor instructor = new Instructor("Tran Van", "Bang","bangyugi@bangvan.com");

		// create instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/@vietnh1009","Guitar");


		// associate objects
		instructor.setInstructorDetail(instructorDetail);

		// save the instructor
		//
		// NOTE: this will also save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);
		System.out.println("Done!!");

	}
}
