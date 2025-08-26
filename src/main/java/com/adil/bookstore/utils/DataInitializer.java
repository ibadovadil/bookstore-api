package com.adil.bookstore.utils;

import com.adil.bookstore.entity.User;
import com.adil.bookstore.enums.Role;
import com.adil.bookstore.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder(12);
    }

    @Override
    public void run(String... args) throws Exception {
        boolean adminExists = userRepository.existsByRole(Role.ROLE_ADMIN);
        if (!adminExists) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@admin.com");
            admin.setPassword(encoder.encode("admin123"));
            admin.setRole(Role.ROLE_ADMIN);
            admin.setCreatedAt(new Date().toInstant());
            userRepository.save(admin);
            System.out.println("Admin user created.");
        } else {
            System.out.println("Admin user already exists.");
        }
    }

}
