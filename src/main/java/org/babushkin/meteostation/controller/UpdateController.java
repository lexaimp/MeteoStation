package org.babushkin.meteostation.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class UpdateController {
    @GetMapping("/update")
    @ResponseBody
    public ResponseEntity<FileSystemResource> update() {
        final FileSystemResource file = new FileSystemResource(new File("D:\\meteo.bin"));
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
