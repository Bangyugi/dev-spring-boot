package com.bangvan.thymeleafdemo.models;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String language;
    private List<String> system;

    public Student() {
    }

    public Student(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public Student(String firstName, String lastName, String country, String language) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.language = language;
    }


    public Student(String firstName, String lastName, String country, String language, List<String> system) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.language = language;
        this.system = system;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getSystem() {
        return system;
    }

    public void setSystem(List<String> system) {
        this.system = system;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                ", system=" + system +
                '}';
    }
}
