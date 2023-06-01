package com.example.nmcnpm.repository;

import com.example.nmcnpm.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan,Long> {
    void deleteById(Long id);
    TaiKhoan findByEmail(String email);
}
