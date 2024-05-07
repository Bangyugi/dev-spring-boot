package com.bangvan.cruddemo;

import com.bangvan.cruddemo.dao.AppDao;
import com.bangvan.cruddemo.entity.Course;
import com.bangvan.cruddemo.entity.Instructor;
import com.bangvan.cruddemo.entity.InstructorDetail;
import com.bangvan.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner -> {
//			createInstructor(appDao);
//			createInstructorWithCourse(appDao);
//			findInstructorWithCourse(appDao);
//			findCourseForInstructor(appDao);
//			findInstructorJoinFetch(appDao);
//			updateInstructorById(appDao);
//			updateCourseById(appDao);
//			deleteInstructor(appDao);
//			deleteCourse(appDao);
//			createCourseWithReviews(appDao);
//			findCourseWithReviewByCourseId(appDao);
			deleteCourseAndReviewsById(appDao);
		};
	}

	private void deleteCourseAndReviewsById(AppDao appDao) {
		int id = 6;
		System.out.println("Deleting course by id: "+id);
		appDao.deleteCourseAndReviewById(id);
		System.out.println("Done!!");
	}

	private void findCourseWithReviewByCourseId(AppDao appDao) {
		int id = 5;
		System.out.println("Finding course id: " + id);
		Course course = appDao.findCourseWithReviewsByCourseId(id);
		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void createCourseWithReviews(AppDao appDao) {
		System.out.println("Creating new course");
		Course course = new Course("Spring boot master class");
		course.addReviews(new Review("This is the greatest course that I've ever seen"));
		course.addReviews(new Review("Cool course, well done!"));
		appDao.createCourse(course);
		System.out.println(course);
		System.out.println("Done!");
	}

	private void deleteCourse(AppDao appDao) {
		int id = 3;
		System.out.println("Deleting course id: " + id);
		appDao.deleteCourseById(id);
		System.out.println("Done!!");
	}

	private void deleteInstructor(AppDao appDao) {
		int id = 4;
		System.out.println("Deleting instructor id: "+id);
		appDao.deleteInstructorById(id);
		System.out.println("Done!!");
	}

	private void updateCourseById(AppDao appDao) {
		int id = 4;
		System.out.println("Finding course id: " + id);
		Course course = appDao.findCourseById(id);
		System.out.println("Updating course id: " + id);
		course.setTitle("Enjoy the Simple Things");
		appDao.updateCourse(course);
		System.out.println("Done!!");
	}

	private void updateInstructorById(AppDao appDao) {
		int id = 2;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDao.findInstructorByID(id);
		System.out.println("Updating instructor id: "+ id);
		instructor.setEmail("nguyentduong1109@gmail.com");
		appDao.updateInstructor(instructor);
		System.out.println("Done!!");
	}

	private void findInstructorJoinFetch(AppDao appDao) {
		int id = 1;
		System.out.println("Find instructor id: " + id);
		Instructor instructor = appDao.findInstructorByIdJoinFetch(id);
		System.out.println("Instructor: " + instructor);
		List<Course> courses = instructor.getCourses();
		InstructorDetail instructorDetail = instructor.getInstructorDetail();
		System.out.println(instructorDetail);
		for (Course course: courses){
			System.out.println(course);
		}
	}

	private void findCourseForInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("Find instructor id: " + id);
		Instructor instructor = appDao.findInstructorByID(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("Finding courses for instructor id: " + id);
		List<Course> courses = appDao.findCourseByInstructorId(id);
		for (Course course: courses){
			System.out.println(course);
		}
	}

	// this method need to change fetch type to EAGER
	private void findInstructorWithCourse(AppDao appDao) {
		int id = 1;
		System.out.println("Find instructor id: " + id);
		Instructor instructor = appDao.findInstructorByID(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("The associated courses: " + instructor.getCourses());
		System.out.println("Done!!");
	}

	private void createInstructorWithCourse(AppDao appDao) {
		Instructor instructor = new Instructor("Dong Binh", "Nam","binhnamdong19@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/channel/UCWcZtTW7vjOn-T_kM1-PjeQ","Guitar");
		instructor.setInstructorDetail(instructorDetail);
		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");
		instructor.addCourse(course1);
		instructor.addCourse(course2);
		System.out.println("Saving instructor: " +instructor);
		System.out.println("The courses: " +instructor.getCourses());
		appDao.createInstructor(instructor);
		System.out.println("Done!!");
	}

	private void createInstructor(AppDao appDao) {
		Instructor instructor = new Instructor("Nguyen Duc", "Kien", "duckien1109@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/channel/UCWcZtTW7vjOn-T_kM1-PjeQ", "Codding");
		instructor.setInstructorDetail(instructorDetail);
		System.out.println("Saving instructor: " + instructor);
		appDao.createInstructor(instructor);
		System.out.println("Done!!");
	}
}
