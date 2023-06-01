package com.example.nmcnpm.service.implement;

import com.example.nmcnpm.model.HinhAnh;
import com.example.nmcnpm.repository.HinhAnhRepository;
import com.example.nmcnpm.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class HinhAnhServiceImp implements HinhAnhService {
    @Autowired
    private HinhAnhRepository hinhAnhRepository;
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    @Override
    public HinhAnh upLoadFile(MultipartFile photo) throws IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(photo.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(photo.getBytes());
        }
        HinhAnh hinhAnh= new HinhAnh();
        hinhAnh.setAnh(imagePath.resolve(photo.getOriginalFilename()).toString());
        return hinhAnhRepository.save(hinhAnh);
    }

    @Override
    public void getFile() {

    }

    @Override
    public List<HinhAnh> findAll() {
        return hinhAnhRepository.findAll();
    }
}
