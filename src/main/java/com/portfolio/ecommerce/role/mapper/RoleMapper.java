package com.portfolio.ecommerce.role.mapper;

import com.portfolio.ecommerce.role.dto.request.RoleRequest;
import com.portfolio.ecommerce.role.dto.response.RoleResponse;
import com.portfolio.ecommerce.role.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleRequest request);

    RoleResponse toResponse(Role role);
}