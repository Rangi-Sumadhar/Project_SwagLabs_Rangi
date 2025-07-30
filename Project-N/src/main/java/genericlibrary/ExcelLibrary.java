package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

 
public class ExcelLibrary implements FrameworkConstant
{
	static FileInputStream 	fis;
	static FileOutputStream fos;
	static Workbook book;
	
	public static void UpdateData(String Sheetname, int row, int coloumn, String data) 
	{
		try {
			fis = new FileInputStream(Excel_Path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		book.getSheet(Sheetname).getRow(row).createCell(coloumn).setCellValue(data);
		
		try {
			fos = new FileOutputStream(Excel_Path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Updating Data succesfull!");
		
	}


	
	
	public static String ReadData(String sheet_name, int row, int coloumn) 
	{
		try {
			fis = new FileInputStream(Excel_Path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String data = book.getSheet(sheet_name).getRow(row).getCell(coloumn).getStringCellValue();
		
		System.out.println("Reading Data succesfull!");
		
		return data;
	}


	
	
	public static void WriteData(String Sheet_name, int row, int coloumn, String data) 

	{
		try {
			fis = new FileInputStream(Excel_Path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		book.createSheet(Sheet_name).createRow(row).createCell(coloumn).setCellValue(data);
		
		try {
			fos = new FileOutputStream(Excel_Path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Writing Data succesfull!");
	}
	
	
	
}
