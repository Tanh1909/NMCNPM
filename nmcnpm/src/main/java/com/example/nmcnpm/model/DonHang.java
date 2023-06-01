package com.example.nmcnpm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DonHang {
    @Id
    private Long id;
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "taiKhoan_id")
    @JsonIgnore
    private TaiKhoan taiKhoan;
}
