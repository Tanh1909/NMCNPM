package com.example.nmcnpm.service;

import com.example.nmcnpm.dto.GioHangDTO;
import com.example.nmcnpm.model.GioHang;

import java.util.List;

public interface GioHangService {
    public GioHang create(GioHangDTO gioHangDTO);
    public void deleteById(Long id);
    public List<GioHang> findAll();
    public GioHang update(Long id,int soLuong);
}
