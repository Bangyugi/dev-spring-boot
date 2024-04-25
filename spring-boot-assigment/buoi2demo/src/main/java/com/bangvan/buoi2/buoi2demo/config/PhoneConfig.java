package com.bangvan.buoi2.buoi2demo.config;

import com.bangvan.buoi2.buoi2demo.Phone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhoneConfig {
    @Bean
    public Phone phone (){
        return new Phone();
    }
}
