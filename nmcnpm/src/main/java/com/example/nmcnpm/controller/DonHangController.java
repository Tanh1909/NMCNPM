package com.example.nmcnpm.controller;

import com.example.nmcnpm.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donhang")
public class DonHangController {
    @Autowired
    private DonHangService donHangService;
    @GetMapping("/create")
    public ResponseEntity<?> create(){
        return ResponseEntity.ok(donHangService.create());
    }
    @GetMapping("")
    public String findAll(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getName().equals("anonymousUser")){
            return "redirect:/login";
        }
        else{
            model.addAttribute("items",donHangService.findAll());
            return "donhang";
        }

    }

}
