package com.adil.bookstore.service.auth;

import com.adil.bookstore.dto.auth.LoginRequest;
import com.adil.bookstore.dto.auth.LoginResponse;
import com.adil.bookstore.dto.auth.RegisterRequest;
import com.adil.bookstore.dto.auth.RegisterResponse;
import com.adil.bookstore.entity.User;
import com.adil.bookstore.enums.Role;
import com.adil.bookstore.repo.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    private final UserRepository repo;
    private final JWTService jwtService;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    private final AuthenticationManager authManager;

    public AuthService(UserRepository repo, AuthenticationManager authManager, JWTService jwtService) {
        this.repo = repo;
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    public RegisterResponse register(RegisterRequest request) {
        if (repo.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username is already taken!");
        }
        if (repo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already in use!");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_USER);

        repo.save(user);

        String token = jwtService.generateToken(user.getUsername(), user.getEmail(), user.getId(), user.getRole().name());
        return new RegisterResponse(
                user.getUsername(),
                user.getEmail(),
                user.getRole().name(),
                token,
                "User registered successfully"
        );
    }

    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsernameOrEmail(),
                        request.getPassword()
                )
        );

        if (authentication.isAuthenticated()){
            User dbUser = repo.findByUsernameOrEmail(request.getUsernameOrEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            String token = jwtService.generateToken(dbUser.getUsername(), dbUser.getEmail(), dbUser.getId(), dbUser.getRole().name());
            return new LoginResponse(token, dbUser.getUsername(), List.of(dbUser.getRole().name()));
        }else{
            throw new RuntimeException("Invalid username/email or password {Authentication failed}");
        }
    }
}
