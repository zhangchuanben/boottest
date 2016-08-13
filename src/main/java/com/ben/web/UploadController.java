package com.ben.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {
	private String directory = getClass().getResource("/").getPath()+"static/upload";
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ResponseEntity<?> uploadFile (
			@RequestParam("uploadfile") MultipartFile uploadfile ) {
		try {
			String fileName = uploadfile.getOriginalFilename();
			String filePath = directory+"/"+fileName;
			if (!new File(directory).exists()) {
				new File(directory).mkdirs();
			}
			BufferedOutputStream stream = 
					new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(uploadfile.getBytes());
			stream.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
