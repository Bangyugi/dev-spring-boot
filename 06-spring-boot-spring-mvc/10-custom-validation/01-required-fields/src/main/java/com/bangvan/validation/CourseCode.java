package com.bangvan.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Constraint(validatedBy = CourseCodeConstraintValidatior.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    // define default course code
    public String value() default "Bang";

    // define default error message
    public String message() default "Bang dep trai";

    // define default group
    public Class<?>[] groups() default{};

    // define default payloads
    public Class<? extends Payload>[] payload() default {};
}
