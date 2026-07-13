package com.portfolio.ecommerce.auth.service;

import com.portfolio.ecommerce.auth.dto.LoginRequest;
import com.portfolio.ecommerce.auth.dto.LoginResponse;
import com.portfolio.ecommerce.auth.dto.RegisterRequest;
import com.portfolio.ecommerce.user.dto.response.UserResponse;

public interface AuthService {

    UserResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}
