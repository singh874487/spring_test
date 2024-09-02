package excelsheet; 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.xssf.usermodel.XSSFSheet; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class WriteExcelSheet2
{ 
public static void main(String[] args) throws IOException
{ 
// Declare a variable 'filePath' with data type String to store the path of the file. 
     String filePath = "F:\\\\Java_test\\\\ExcelSheet\\\\ExcelSheet.xlsx"; 

// Create an object of the file class and pass the 'filePath' as a parameter to open xlsx based data file. 
     File file = new File(filePath); 

// Create an object of the FileInputStream class and pass the reference variable 'file' as a parameter to read excel data file. 
     FileInputStream fis = new FileInputStream(file); 

// Create the object of XSSFWorkbook class and pass the reference variable 'fis' as a parameter. 
     XSSFWorkbook wb = new XSSFWorkbook(fis); 

// Create a blank sheet with sheet name 'My First ExcelSheet'. 
     XSSFSheet sheet = wb.createSheet("My Sec ExcelSheet"); 

// Create an array object and initialize the data. 
     Object[][] countryData = { 
          {"SNo", "Country", "Capital", "Currency"}, 
          {"1", "India", "Delhi", "Indian Rupee"}, 
          {"2", "France", "Paris", "Euro"}, 
          {"3", "USA", "NewYork", "Dollar"}, 
          {"4", "Australia", "Canberra", "Australian dollar"}, 
          {"5", "Japan", "Tokyo", "Japanese yen"}, 
          {"6", "Russia", "Moscow", "Ruble"} 
       }; 
// Create rows and iterate them. 
    int rowCount = 0; 
    for (Object[] arrayData : countryData) 
    { 
       Row row = sheet.createRow(rowCount++); 
// Create cells in each row, iterate them and set the cell value. 
       int columnCount = 0; 
         for (Object obj : arrayData) 
         { 
            Cell cell = row.createCell(columnCount++); 
            if (obj instanceof String) 
            { 
              cell.setCellValue((String)obj); 
             } 
            else if (obj instanceof Integer) 
            { 
               cell.setCellValue((Integer)obj); 
            } 
          } 
        } 
FileOutputStream fos = new FileOutputStream(filePath); 
wb.write(fos); 
fos.close(); 
System.out.println("ExcelSheet1.xlsx written successfully"); 
  } 
}