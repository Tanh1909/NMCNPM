package com.example.nmcnpm.model;

import com.example.nmcnpm.dto.SanPhamDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenSP;
    private double gia;
    private String moTa;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hinhAnh_id")
    private HinhAnh hinhAnh;

    @OneToMany(mappedBy = "sanPham",cascade = CascadeType.ALL)
    List<GioHang> gioHangs;

    public SanPham(SanPhamDTO sanPhamDTO){
        this.tenSP=sanPhamDTO.getTenSP();
        this.gia=sanPhamDTO.getGia();
        this.moTa=sanPhamDTO.getMoTa();
    }
}
