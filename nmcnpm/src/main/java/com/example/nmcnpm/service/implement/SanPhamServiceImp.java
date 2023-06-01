package com.example.nmcnpm.service.implement;

import com.example.nmcnpm.dto.SanPhamDTO;
import com.example.nmcnpm.model.SanPham;
import com.example.nmcnpm.repository.SanPhamRepository;
import com.example.nmcnpm.service.HinhAnhService;
import com.example.nmcnpm.service.SanPhamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class SanPhamServiceImp implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private HinhAnhService hinhAnhService;

    @Override
    public SanPham save(SanPhamDTO sanPhamDTO) throws IOException {
        SanPham sanPham=new SanPham(sanPhamDTO);
        sanPham.setHinhAnh(hinhAnhService.upLoadFile(sanPhamDTO.getHinhAnh()));
        return sanPhamRepository.save(sanPham);
    }

    @Override
    public void remove(Long id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public List<SanPham> findAll() {
        return sanPhamRepository.findAll();
    }
}
