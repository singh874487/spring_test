package com.files.excel.controller;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import org.apache.poi.xssf.usermodel.XSSFCell; 
import org.apache.poi.xssf.usermodel.XSSFRow; 
import org.apache.poi.xssf.usermodel.XSSFSheet; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class WriteExcelSheet 
{ 
public static void main(String[] args) throws IOException 
{ 
// Declare a variable 'filePath' with data type String to store the path of the file. 
     String filePath = "F:\\Java_test\\ExcelSheet\\ExcelSheet.xlsx"; 

// Create an object of the file class and pass the 'filePath' as a parameter to open xlsx based data file. 
     File file = new File(filePath); 

// Create an object of the FileInputStream class and pass the reference variable 'file' as a parameter to read excel data file. 
     FileInputStream fis = new FileInputStream(file); 

// Create the object of XSSFWorkbook class and pass the reference variable 'fis' as a parameter. 
     XSSFWorkbook wb = new XSSFWorkbook(fis); 

// Call getSheet() method to read excel sheet by sheet name. 
     XSSFSheet sheet=wb.getSheet("Sheet1"); 

// Call getRow() method to read row by row number. 
     XSSFRow row = sheet.getRow(1); // Return type of getRow method is a XSSFRow. 

// Create a third cell in the second row and set the cell value 'Pass'. 
     XSSFCell cell = row.createCell(2); 
     cell.setCellValue("Pass"); // This method returns nothing. 

// Or, In one line code: 
     sheet.getRow(1).createCell(2).setCellValue("Pass"); 

// Similarly, for the third row and third cell. 
     sheet.getRow(2).createCell(2).setCellValue("Fail"); 
     sheet.getRow(3).createCell(2).setCellValue("Pass"); 

// Create an object of FileOutputStream class to create the write data in excel file. 
     FileOutputStream fos = new FileOutputStream(filePath); 

// Write data in the excel file. 
      wb.write(fos); 

// Close the output stream. 
      fos.close(); 
      System.out.println("Result Written Successfully"); 
   } 
}