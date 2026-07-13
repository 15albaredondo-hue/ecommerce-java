package com.portfolio.ecommerce.role.service.impl;

import com.portfolio.ecommerce.role.dto.request.RoleRequest;
import com.portfolio.ecommerce.role.dto.response.RoleResponse;
import com.portfolio.ecommerce.role.entity.Role;
import com.portfolio.ecommerce.role.mapper.RoleMapper;
import com.portfolio.ecommerce.role.repository.RoleRepository;
import com.portfolio.ecommerce.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolio.ecommerce.common.enums.RoleName;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleResponse create(RoleRequest request) {

        Role role = roleMapper.toEntity(request);

        Role savedRole = roleRepository.save(role);

        return roleMapper.toResponse(savedRole);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleResponse> findAll() {

        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public RoleResponse findById(Long id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        return roleMapper.toResponse(role);
    }

    @Override
    public void delete(Long id) {

        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Role not found");
        }

        roleRepository.deleteById(id);
    }

    @Override
public RoleResponse update(Long id, RoleRequest request) {

    Role role = roleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Role not found"));

    role.setName(RoleName.valueOf(request.getName()));


    Role updatedRole = roleRepository.save(role);

    return roleMapper.toResponse(updatedRole);
}
}
