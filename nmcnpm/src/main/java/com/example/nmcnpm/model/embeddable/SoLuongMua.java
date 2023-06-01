package com.example.nmcnpm.model.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class SoLuongMua implements Serializable {
    @Column(name = "sanPham_id")
    private Long sanPhamId;
    @Column(name = "donHang_id")
    private Long donHangId;
}
