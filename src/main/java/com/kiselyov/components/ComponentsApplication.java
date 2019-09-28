package com.kiselyov.components;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(ignoreResourceNotFound = true, value = "classpath:/db.properties")
@PropertySource(ignoreResourceNotFound = true, value = "file:${COMPONENTS_HOME}/db.properties")
@PropertySource(ignoreResourceNotFound = true, value = "file:${user.home}/.myapp/db.properties")
@ComponentScan("com.kiselyov")
public class ComponentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComponentsApplication.class, args);
    }

}
