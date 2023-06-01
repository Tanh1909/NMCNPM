package com.example.nmcnpm.controller.screen;

import com.example.nmcnpm.model.GioHang;
import com.example.nmcnpm.model.TaiKhoan;
import com.example.nmcnpm.service.SanPhamService;
import com.example.nmcnpm.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ScreenController {
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @GetMapping("/login")
    public String login(){
        return "SignIn";
    }
    @GetMapping(value = {"/","/store"})
    public String store(Model model){
        model.addAttribute("size", sanPhamService.findAll());
        model.addAttribute("items",sanPhamService.findAll());
        return "store";
    }
    @GetMapping("/giohang")
    public String gioHang(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getName().equals("anonymousUser")){
              return "redirect:/login";
        }
        else{
            UserDetails userDetails=(UserDetails) authentication.getPrincipal();
            TaiKhoan taiKhoan=taiKhoanService.findByUserName(userDetails.getUsername());
            model.addAttribute("items",taiKhoan.getGioHangs());
            return "gioHang";
        }
    }
}
