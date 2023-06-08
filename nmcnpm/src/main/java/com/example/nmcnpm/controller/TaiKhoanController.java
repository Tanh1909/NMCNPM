package com.example.nmcnpm.controller;

import com.example.nmcnpm.model.TaiKhoan;
import com.example.nmcnpm.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/taikhoan")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;
    @PostMapping("/signup")
    public String create(@ModelAttribute TaiKhoan taiKhoan, Model model){
        if(taiKhoanService.create(taiKhoan)){
            return "redirect:/login";
        }
        else{
            model.addAttribute("error","email da ton tai!");
            return "signup";
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(taiKhoanService.findAll());
    }
}
