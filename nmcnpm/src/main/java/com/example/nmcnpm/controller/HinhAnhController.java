package com.example.nmcnpm.controller;

import com.example.nmcnpm.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/hinhanh")
public class HinhAnhController {
    @Autowired
    private HinhAnhService hinhAnhService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@ModelAttribute MultipartFile photo) throws IOException {
        return ResponseEntity.ok(hinhAnhService.upLoadFile(photo));
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll()  {
        return ResponseEntity.ok(hinhAnhService.findAll());
    }
}
