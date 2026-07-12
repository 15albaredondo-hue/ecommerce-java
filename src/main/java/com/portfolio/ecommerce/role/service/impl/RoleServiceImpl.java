package com.portfolio.ecommerce.role.service.impl;

import com.portfolio.ecommerce.role.entity.Role;
import com.portfolio.ecommerce.role.repository.RoleRepository;
import com.portfolio.ecommerce.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Long id, Role role) {

        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        existingRole.setName(role.getName());

        return roleRepository.save(existingRole);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
