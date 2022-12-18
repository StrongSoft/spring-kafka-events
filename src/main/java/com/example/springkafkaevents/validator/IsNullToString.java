package com.example.springkafkaevents.validator;

import com.example.springkafkaevents.validator.IsNullToString.IsNullValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = IsNullToString.IsNullValidator.class)
@Target( { ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsNullToString {

    String message() default "빈 값은 안됩니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class IsNullValidator implements ConstraintValidator<IsNullToString, String> {

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            System.out.println("value = " + value);
            return Objects.nonNull(value);
        }
    }
}
