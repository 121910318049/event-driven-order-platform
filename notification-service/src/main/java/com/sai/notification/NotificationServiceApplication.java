
package com.sai.notification;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class NotificationServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(NotificationServiceApplication.class,args);
  }


  @Bean
  CommandLineRunner test(ApplicationContext context) {
      return args -> {
          System.out.println("APPLICATION STARTED");

          System.out.println(
                  "Controller exists: " +
                          context.containsBean("notifycontroller")
          );
      };
  }
}
