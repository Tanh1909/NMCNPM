package com.example.nmcnpm.repository;

import com.example.nmcnpm.model.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HinhAnhRepository extends JpaRepository<HinhAnh,Long> {
    void deleteById(Long id);
}
