package com.learn.springboot.myfirstwebapp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){


        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("sree")
                .password("sree")
                .roles("USER", "ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(userDetails);
    }

}
