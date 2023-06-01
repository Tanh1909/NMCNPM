package com.example.nmcnpm.service.implement;

import com.example.nmcnpm.dto.GioHangDTO;
import com.example.nmcnpm.model.GioHang;
import com.example.nmcnpm.model.SanPham;
import com.example.nmcnpm.model.TaiKhoan;
import com.example.nmcnpm.repository.GioHangRepository;
import com.example.nmcnpm.repository.SanPhamRepository;
import com.example.nmcnpm.repository.TaiKhoanRepository;
import com.example.nmcnpm.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GioHangServiceImp implements GioHangService {
    @Autowired
    private GioHangRepository gioHangRepository;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Override
    public GioHang create(GioHangDTO gioHangDTO) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            TaiKhoan taiKhoan=taiKhoanRepository.findByEmail(username);
            SanPham sanPham=sanPhamRepository.findById(gioHangDTO.getSanPhamId()).get();
            GioHang gioHang=new GioHang();
            int sl=gioHangDTO.getSoLuong();
            for (GioHang x:gioHangRepository.findAll()) {
                    if(x.getSanPham().getId()==sanPham.getId()&&x.getTaiKhoan().getId()==taiKhoan.getId()){
                        sl++;
                        gioHang.setId(x.getId());
                        break;
                    }
            }
            gioHang.setTaiKhoan(taiKhoan);
            gioHang.setSanPham(sanPham);
            gioHang.setSoLuong(sl);
           return gioHangRepository.save(gioHang);

    }

    @Override
    public void deleteById(Long id) {
        gioHangRepository.deleteById(id);
    }
    public List<GioHang> findAll(){
        return gioHangRepository.findAll();
    }


    public GioHang update(Long id,int soLuong) {
        Optional<GioHang> gioHangOptional = gioHangRepository.findById(id);
        GioHang gioHang = gioHangOptional.get();
        gioHang.setSoLuong(soLuong);
       return gioHangRepository.save(gioHang);
    }
}
