package com.example.nmcnpm.repository;

import com.example.nmcnpm.model.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GioHangRepository extends JpaRepository<GioHang,Long> {
    public void deleteById(Long id);
}
