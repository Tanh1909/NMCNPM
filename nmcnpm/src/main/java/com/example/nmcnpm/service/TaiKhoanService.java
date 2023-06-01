package com.example.nmcnpm.service;

import com.example.nmcnpm.model.TaiKhoan;

import java.util.List;

public interface TaiKhoanService {
    TaiKhoan create(TaiKhoan taiKhoan);
    void remove(Long id);
    List<TaiKhoan> findAll();
    TaiKhoan findByUserName(String username);
}
