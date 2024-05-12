package com.bangvan.demo;

import com.bangvan.demo.dao.AppDao;
import com.bangvan.demo.entity.Course;
import com.bangvan.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner ->
		{
//			createStudentWithCourse(appDao);
//			createCourseWithStudents(appDao);
//			findStudentWithCourseById(appDao);
//			findCourseWithStudentById(appDao);
//			addMoreCoursesForStudent(appDao);
//			deleteStudentById(appDao);
			deleteCourseById(appDao);
		};
	}

	private void deleteCourseById(AppDao appDao) {
		int id = 2;
		System.out.println("Deleting course id: " + id);
		appDao.deleteCourseByID(id);
		System.out.println("Done!");
	}

	private void deleteStudentById(AppDao appDao) {
		int id = 2;
		System.out.println("Deleting student id: " + id);
		appDao.deleteStudentById(id);
		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDao appDao) {
		int id = 3;
		Student student = appDao.findStudentWithCourseById(id);
		Course course1 = new Course("Rubik's Cube - How to Speed Cube");
		Course course2 = new Course("Atari 2600 - Game Development");

		student.addCourse(course1);
		student.addCourse(course2);
		System.out.println("Saving student: " + student);
		appDao.updateStudent(student);
		System.out.println("Done!");
	}

	private void findCourseWithStudentById(AppDao appDao) {
		int id = 1;
		System.out.println("Finding course id: " + id);
		Course course = appDao.findCourseWithStudentById(id);
		System.out.println("Course: " +course);
		System.out.println("Associate student: " + course.getStudents());
	}

	private void findStudentWithCourseById(AppDao appDao) {
		int id = 1;
		System.out.println("Finding Student id: " + id);
		Student student = appDao.findStudentWithCourseById(id);
		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void createCourseWithStudents(AppDao appDao) {
		System.out.println("Creating course . . . ");
		Course course = new Course("Guitar master class");
		Student student1 = new Student("Nguyen Duc", "Kien", 3.6);
		Student student2 = new Student("Dong Binh", "Nam", 3.7);
		course.addStudent(student1);
		course.addStudent(student2);
		System.out.println("Saving course: " + course);
		System.out.println("Associate student: "+ course.getStudents());
		appDao.createCourseWithStudent(course);
		System.out.println("Done!");
	}

	private void createStudentWithCourse(AppDao appDao) {
		System.out.println("Creating student . . .");
		Student student1 = new Student("Tran Van", "Bang", 3.6);
		Course course1 = new Course("Spring boot, Spring framework");
		Course course2 = new Course("HTML, CSS and JavaScript for web developer");
		student1.addCourse(course1);
		student1.addCourse(course2);
		System.out.println("Saving student: " + student1);
		System.out.println("Associate course: " + student1.getCourses());
		appDao.createStudentWithCourse(student1);
		System.out.println("Done!");
	}


}
