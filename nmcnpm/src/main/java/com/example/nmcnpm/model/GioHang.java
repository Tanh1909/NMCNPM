package com.example.nmcnpm.model;

import com.example.nmcnpm.model.embeddable.SoLuongEmbed;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class GioHang {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sanPham_id")
    @JsonIgnore
    private SanPham sanPham;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "taiKhoan_id")
    private TaiKhoan taiKhoan;

    private int soLuong;


}
