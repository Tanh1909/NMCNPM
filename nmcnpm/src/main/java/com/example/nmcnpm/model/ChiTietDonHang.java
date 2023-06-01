package com.example.nmcnpm.model;

import com.example.nmcnpm.model.embeddable.SoLuongMua;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ChiTietDonHang {
    @EmbeddedId
    private SoLuongMua soLuongMua;

    @ManyToOne
    @MapsId("sanPham_id")
    @JoinColumn(name = "sanPham_id")
    private SanPham sanPham;

    @ManyToOne
    @MapsId("donHang_id")
    @JoinColumn(name = "donHang_id")
    private DonHang donHang;

    private int soLuong;
}
