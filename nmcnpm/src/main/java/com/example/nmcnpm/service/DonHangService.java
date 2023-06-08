package com.example.nmcnpm.service;

import com.example.nmcnpm.model.DonHang;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DonHangService {
    public DonHang create();
    public List<DonHang> findAll();
}
