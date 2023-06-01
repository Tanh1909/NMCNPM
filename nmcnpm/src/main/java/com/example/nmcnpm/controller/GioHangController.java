package com.example.nmcnpm.controller;

import com.example.nmcnpm.dto.GioHangDTO;
import com.example.nmcnpm.security.SimpleGrant;
import com.example.nmcnpm.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/giohang")
public class GioHangController {
    @Autowired
    private GioHangService gioHangService;
    @PostMapping("/create")
    public String create(GioHangDTO gioHangDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getName().equals("anonymousUser")){
                return "redirect:/login";
        }
        else{
            gioHangService.create(gioHangDTO);
            return "redirect:/store";
        }
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        gioHangService.deleteById(id);
        return "redirect:/giohang";

    }
    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestParam int soLuong){
        return ResponseEntity.ok(gioHangService.update(id, soLuong));
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(gioHangService.findAll());
    }
}
