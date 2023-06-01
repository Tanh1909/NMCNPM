package com.example.nmcnpm.service;

import com.example.nmcnpm.model.HinhAnh;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HinhAnhService {
    HinhAnh upLoadFile(MultipartFile photo) throws IOException;
    void getFile();
    List<HinhAnh> findAll();
}
