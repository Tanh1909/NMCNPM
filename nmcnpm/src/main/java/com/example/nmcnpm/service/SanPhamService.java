package com.example.nmcnpm.service;

import com.example.nmcnpm.dto.SanPhamDTO;
import com.example.nmcnpm.model.SanPham;

import java.io.IOException;
import java.util.List;

public interface SanPhamService {
    SanPham save(SanPhamDTO sanPhamDTO) throws IOException;
    void remove(Long id);
    List<SanPham> findAll();
}
