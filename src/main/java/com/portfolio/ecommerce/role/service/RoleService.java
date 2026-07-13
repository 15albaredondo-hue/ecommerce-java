package com.portfolio.ecommerce.role.service;

import com.portfolio.ecommerce.role.dto.request.RoleRequest;
import com.portfolio.ecommerce.role.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {

    RoleResponse create(RoleRequest request);

    List<RoleResponse> findAll();

    RoleResponse findById(Long id);

     RoleResponse update(Long id, RoleRequest request);

    void delete(Long id);

}