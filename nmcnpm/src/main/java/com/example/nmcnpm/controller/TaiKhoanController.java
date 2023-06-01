package com.example.nmcnpm.controller;

import com.example.nmcnpm.model.TaiKhoan;
import com.example.nmcnpm.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taikhoan")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@ModelAttribute TaiKhoan taiKhoan){
        return ResponseEntity.ok(taiKhoanService.create(taiKhoan));
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(taiKhoanService.findAll());
    }
}
