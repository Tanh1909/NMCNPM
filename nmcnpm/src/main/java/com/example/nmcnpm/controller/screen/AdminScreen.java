package com.example.nmcnpm.controller.screen;

import com.example.nmcnpm.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminScreen {
    @Autowired
    private SanPhamService sanPhamService;
    @GetMapping("/ui")
    public String UI(Model model){
        model.addAttribute("items",sanPhamService.findAll());
        return "admin";
    }
    @GetMapping("/add")
    public String add(){
        return "add";
    }
}
