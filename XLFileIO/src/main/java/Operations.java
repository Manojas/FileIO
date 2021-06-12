import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Operations {
public void writToNotePAd() throws IOException
{
	File file = new File("C:\\Users\\Admin\\Documents\\New folder\\Students.xlsx");
	File file2=new File("Students.txt");
	FileInputStream fis = null;
	Writer fw=null;
	try {
		fis = new FileInputStream(file);
         fw=new FileWriter(file2);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workBook.getSheetAt(0);

		Iterator<Row> itr = sheet.iterator();

		while (itr.hasNext()) {
			Row row = itr.next();

			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING: // field that represents string cell type
					fw.write(String.valueOf(cell.getStringCellValue()));
					System.out.print(cell.getStringCellValue() + "\t\t\t");
				
					break;
				case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
					fw.write(String.valueOf(cell.getNumericCellValue()));
					System.out.print(cell.getNumericCellValue() + "\t\t\t");
					
					break;
				default:
				}
				fw.write("     ");
				System.out.print("     ");
			}
			fw.write("\n");
			System.out.println("");
		}
		workBook.close();
		fw.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public double creatTotal() {
	double sum=0;
	
	File file = new File("C:\\Users\\Admin\\Documents\\New folder\\Students.xlsx");
	File file2=new File("Students.txt");
	FileInputStream fis = null;
	FileOutputStream fout = null;
	Writer fw=null;
	double age=0;
	try {
		fis = new FileInputStream(file);
         fw=new FileWriter(file2);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workBook.getSheetAt(0);

		Iterator<Row> rows = sheet.iterator();
		rows.next();
        int count=1;
		while (rows.hasNext()) {
			count++;
			Row row=rows.next();
			sum+=row.getCell(1).getNumericCellValue();

		}
		XSSFRow row=(XSSFRow)sheet.createRow(count);
		Cell cell=row.createCell(0);
		cell.setCellValue("Sum");
		Cell cell2=row.createCell(1);
		cell2.setCellValue(sum);
		fout=new FileOutputStream("C:\\Users\\Admin\\Documents\\New folder\\Students.xlsx");
		workBook.write(fout);
		workBook.close();
		
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	
	
	
	return sum;
	// TODO Auto-generated method stub
	
}

public double getAge(String name) {
	// TODO Auto-generated method stub
	File file = new File("C:\\Users\\Admin\\Documents\\New folder\\Students.xlsx");
	File file2=new File("Students.txt");
	FileInputStream fis = null;
	Writer fw=null;
	double age=0;
	try {
		fis = new FileInputStream(file);
         fw=new FileWriter(file2);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workBook.getSheetAt(0);

		Iterator<Row> itr = sheet.iterator();

		while (itr.hasNext()) {
			Row row = itr.next();

		//	Iterator<Cell> cellIterator = row.cellIterator();
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(name))
			{
				 age=row.getCell(1).getNumericCellValue();
			}
		}
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	return age;
}

public String updateHeight(String name, double height) {
	// TODO Auto-generated method stub
	File file = new File("C:\\Users\\Admin\\Documents\\New folder\\Students.xlsx");
	File file2=new File("Students.txt");
	FileInputStream fis = null;
	Writer fw=null;
	double age=0;
	String result="";
	try {
		fis = new FileInputStream(file);
         fw=new FileWriter(file2);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workBook.getSheetAt(0);

		Iterator<Row> itr = sheet.iterator();

		while (itr.hasNext()) {
			Row row = itr.next();

		//	Iterator<Cell> cellIterator = row.cellIterator();
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(name))
			{
				 //age=row.getCell(1).getNumericCellValue();
				Cell cell=row.getCell(2);
				cell.setCellValue(height);
				
				 result="Height updated";
			}
			else
			{
				 result="Didnt Find such name";
			}
		}
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	return result;
}
}
