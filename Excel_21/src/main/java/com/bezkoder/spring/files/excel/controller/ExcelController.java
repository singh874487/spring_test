package com.bezkoder.spring.files.excel.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.bezkoder.spring.files.excel.service.ExcelService;

@Controller
@RequestMapping("/api/excel")
public class ExcelController {

	// @Autowired
	// ExcelService fileService;

	@GetMapping("/download_2")
	public ResponseEntity<Resource> getFile2() throws Exception {

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Sheet Name");
		XSSFRow row = sheet.createRow(0);

		XSSFCell cell = row.createCell(0);

		FileOutputStream fos = new FileOutputStream("c:/");
		wb.write(fos);

		fos.close();
		return null;

	}

}

//http://localhost:8888/actuator
//http://localhost:8888/api/excel/download
