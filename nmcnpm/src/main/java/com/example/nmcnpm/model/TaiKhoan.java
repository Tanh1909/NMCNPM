package com.example.nmcnpm.model;

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
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hoTen;
    private String soDT;
    private String gioiTinh;
    private String email;
    private String matKhau;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "taiKhoan")
    List<GioHang> gioHangs;

    @OneToMany(mappedBy = "taiKhoan")
    List<DonHang> donHangs;
}
