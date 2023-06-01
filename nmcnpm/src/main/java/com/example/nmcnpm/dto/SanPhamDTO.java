package com.example.nmcnpm.dto;

import com.example.nmcnpm.model.HinhAnh;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamDTO {
    private String tenSP;
    private double gia;
    private String moTa;
    private MultipartFile hinhAnh;
}
