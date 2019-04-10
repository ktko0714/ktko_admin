package com.ktko.admin.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional
public @interface AdminTransactional {

    @AliasFor(annotation = Transactional.class) int timeout() default 10;

    @AliasFor(annotation = Transactional.class) boolean readOnly() default false;

    Propagation propagation() default Propagation.REQUIRED;
}
