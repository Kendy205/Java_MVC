package vn.hoidanit.laptopshop.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.entity.Role;
import vn.hoidanit.laptopshop.repository.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;

    }

    public Optional<Role> getRoleById(Long id) {
        return this.roleRepository.findById(id);
    }

    public Optional<Role> getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }
}
