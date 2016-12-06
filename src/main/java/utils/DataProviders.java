package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class DataProviders {
	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	private static Object[][] getTableArray(String sheetName){
		String[][]tableArray = null;
		
		try{
			File source = new File("Resources/excelFiles/sheet35.xlsx");
			FileInputStream fileInput = new FileInputStream(source);
			
			ExcelWBook = new XSSFWorkbook(fileInput);
			excelWSheet = ExcelWBook.getSheetAt(0);
			
			int startRow = 0;
			int startCol = 0;
			int ci,cj;
			int totalRows = excelWSheet.getLastRowNum();
			int totalCols = 4;
			
			tableArray = new String[totalRows][totalCols];
			
				ci =0;
				for(int i=startRow;i<totalRows;i++,ci++){
					cj=0;
					
					for(int j=startCol;j<totalCols;j++,cj++){
						tableArray[ci][cj]= getCellData(i,j);
						System.out.println(tableArray[ci][cj]);
					}
				}
			}
		catch(FileNotFoundException e){
			e.getMessage();
			e.printStackTrace();
			System.out.println("couldn't read excel Sheet");
		}
		catch(IOException e){
			e.getMessage();
			e.printStackTrace();
			System.out.println("couldn't read excel Sheet");
		}
		catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		
			return (tableArray);
	}
	
	
	private static String getCellData(int RowNum, int ColNum) {
		 
		try{

			Cell = excelWSheet.getRow(RowNum).getCell(ColNum);
				Cell.setCellType(1);
				String cellData = Cell.getStringCellValue();
				return cellData;

			}catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);

			}
		}

	@DataProvider
	public Object[][]test(){
		Object[][] testObArray = getTableArray("Sheet1");
		return (testObArray);
	}
}
	
