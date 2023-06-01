package com.example.nmcnpm.model.embeddable;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoLuongEmbed implements Serializable {
    @Column(name = "sanPham_id")
    private Long sanPhamId;
    @Column(name = "taiKhoan_id")
    private Long TaiKhoanId;
}
