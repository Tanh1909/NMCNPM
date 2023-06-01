package com.example.nmcnpm.service.implement;

import com.example.nmcnpm.model.Role;
import com.example.nmcnpm.model.TaiKhoan;
import com.example.nmcnpm.repository.RoleRepository;
import com.example.nmcnpm.repository.TaiKhoanRepository;
import com.example.nmcnpm.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaiKhoanServiceImp implements TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public TaiKhoan create(TaiKhoan taiKhoan) {
            taiKhoan.setRole(roleRepository.findById(1L).get());
            taiKhoan.setMatKhau(passwordEncoder.encode(taiKhoan.getMatKhau()));
            return taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public void remove(Long id) {
        taiKhoanRepository.deleteById(id); ;
    }

    @Override
    public List<TaiKhoan> findAll() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public TaiKhoan findByUserName(String username) {
        return taiKhoanRepository.findByEmail(username);
    }
}
