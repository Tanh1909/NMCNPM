package com.example.nmcnpm.repository;

import com.example.nmcnpm.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamRepository extends JpaRepository<SanPham,Long> {
    void deleteById(Long id);
}
