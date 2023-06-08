package com.example.nmcnpm.service.implement;

import com.example.nmcnpm.model.DonHang;
import com.example.nmcnpm.model.TaiKhoan;
import com.example.nmcnpm.repository.DonHangRepository;
import com.example.nmcnpm.repository.TaiKhoanRepository;
import com.example.nmcnpm.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DonHangServiceImp implements DonHangService {
    @Autowired
     private DonHangRepository donHangRepository;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public DonHang create() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        TaiKhoan taiKhoan=taiKhoanRepository.findByEmail(username);
        DonHang donHang=new DonHang();
        donHang.setTrangThai("Đặt hàng thành công");
        donHang.setTaiKhoan(taiKhoan);
        return donHangRepository.save(donHang);
    }

    @Override
    public List<DonHang> findAll() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        TaiKhoan taiKhoan=taiKhoanRepository.findByEmail(username);
        return taiKhoan.getDonHangs();
    }
}
