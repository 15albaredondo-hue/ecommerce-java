package com.portfolio.ecommerce.auth.service.impl;

import com.portfolio.ecommerce.auth.dto.LoginRequest;
import com.portfolio.ecommerce.auth.dto.LoginResponse;
import com.portfolio.ecommerce.auth.dto.RegisterRequest;
import com.portfolio.ecommerce.auth.service.AuthService;
import com.portfolio.ecommerce.role.repository.RoleRepository;
import com.portfolio.ecommerce.user.dto.response.UserResponse;
import com.portfolio.ecommerce.user.mapper.UserMapper;
import com.portfolio.ecommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.portfolio.ecommerce.common.exception.NotFoundException;
import com.portfolio.ecommerce.user.entity.User;
import com.portfolio.ecommerce.common.exception.BadRequestException;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
public UserResponse register(RegisterRequest request) {

    if (userRepository.existsByEmail(request.getEmail())) {
        throw new BadRequestException("El email ya está registrado");
    }

    var role = roleRepository.findById(request.getRoleId())
            .orElseThrow(() -> new NotFoundException("Rol no encontrado"));

    User user = new User();

    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setRole(role);

    User savedUser = userRepository.save(user);

    return userMapper.toResponse(savedUser);
}

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }

}
