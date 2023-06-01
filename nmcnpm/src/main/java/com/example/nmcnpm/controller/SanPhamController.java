package com.example.nmcnpm.controller;

import com.example.nmcnpm.dto.SanPhamDTO;
import com.example.nmcnpm.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@ModelAttribute SanPhamDTO sanPhamDTO) throws IOException {
        return ResponseEntity.ok(sanPhamService.save(sanPhamDTO));
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(sanPhamService.findAll());
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        sanPhamService.remove(id);
        return"redirect:/admin/ui";
    }
}
