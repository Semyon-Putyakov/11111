package com.example.demo;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class ImageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/compress")
    public ResponseEntity<byte[]> compressAndDownload(@RequestParam("file") MultipartFile file,
                                                      @RequestParam("quality") float quality) throws IOException {
        if (file.isEmpty() || quality < 0.1 || quality > 1.0) {
            return ResponseEntity.badRequest().build();
        }

        ByteArrayOutputStream compressedStream = new ByteArrayOutputStream();
        Thumbnails.of(file.getInputStream())
                .scale(quality)
                .outputFormat("jpg")
                .outputQuality(quality)
                .toOutputStream(compressedStream);

        byte[] compressedImage = compressedStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        String filename = "compressed.jpg";

        String encodedFilename = URLEncoder.encode(filename, StandardCharsets.UTF_8).replaceAll("\\+", "%20");

        headers.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + encodedFilename + "\"; filename*=UTF-8''" + encodedFilename);

        return new ResponseEntity<>(compressedImage, headers, HttpStatus.OK);
    }
}