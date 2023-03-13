package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	static FileInputStream fileInputStream;
	static XSSFWorkbook xssfWorkBook;
	static XSSFSheet xssfSheet;

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static String getReadStringData(int i, int j) throws IOException {
		fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelRead\\userData.xlsx");
		xssfWorkBook = new XSSFWorkbook(fileInputStream);
		xssfSheet = xssfWorkBook.getSheet("Sheet1");
		Row r = xssfSheet.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}

	public static String getReadIntegerData(int i, int j) throws IOException {
		fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelRead\\userData.xlsx");
		xssfWorkBook = new XSSFWorkbook(fileInputStream);
		xssfSheet = xssfWorkBook.getSheet("Sheet1");
		Row r = xssfSheet.getRow(i);
		Cell c = r.getCell(j);
		int v = (int) c.getNumericCellValue();
		return String.valueOf(v);
	}

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = ExcelWSheet.getLastRowNum();
			int totalCols = 2;
			tabArray = new String[totalRows][totalCols];
			ci = 0;
			for (int i = startRow; i <= totalRows; i++, ci++) {
				cj = 0;
				for (int j = startCol; j <= totalCols-1
						; j++, cj++) {
					tabArray[ci][cj] = getCellData(i, j);
					System.out.println(tabArray[ci][cj]);
				}
			}
		}

		catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}

		catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabArray);
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			if(Cell == null)
			{
			  return "";
			}
			CellType dataType = Cell.getCellType();
			if (dataType.ordinal()==3) {
				return "";
			} else {
				String CellData = Cell.getStringCellValue();
				return CellData;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw (e);
		}
	}
}
