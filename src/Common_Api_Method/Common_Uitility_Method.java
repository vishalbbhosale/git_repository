package Common_Api_Method;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class Common_Uitility_Method {
	public static void evidancecreator(String Filename, String Requestbody, String Responsebody, int statuscode)
			throws IOException {
		File vishal = new File("C:\\Selenium\\" + Filename + ".txt");
		System.out.println("new balnk file name:" + vishal.getName());

		FileWriter datawrite = new FileWriter(vishal);
		datawrite.write("Requestbody is :" + Requestbody + "\n\n");
		datawrite.write("Responsebody is:" + Responsebody + "\n\n");
		datawrite.write("status cose is:" + statuscode);

		datawrite.close();
		System.out.println("data is writen in text file:\"+vishal.getName()");

	}

	public static ArrayList<String> ReadDataExcel(String FileName, String TestCaseName) throws IOException {

		ArrayList<String> ArrayData = new ArrayList<String>();

		// create the object of file input stream to locate the excel file
		FileInputStream Fis = new FileInputStream("C:\\Selenium\\Book2.xlsx");

		// open the excel file by creating the object XSSFSWorkbook
		XSSFWorkbook WorkBook = new XSSFWorkbook(Fis);

		// open the desired sheet
		int countofsheet = WorkBook.getNumberOfSheets();
		for (int i = 0; i < countofsheet; i++) {
			String SheetName = WorkBook.getSheetName(i);

			// Access the desired sheet
			if (SheetName.equalsIgnoreCase(SheetName)) {
				// use XSSFSheet to save the sheet into a variable XSSFSheet
				XSSFSheet Sheet = WorkBook.getSheetAt(i);

				// create iterator TO iterate through row and find out in which column the test
				// case name found
				Iterator<Row> Rows = Sheet.iterator();
				Row FirstRow = Rows.next();

				// create the iterator to iterate through the cells of first row to find out
				// with cell contnts test case name
				Iterator<Cell> CellsofFirstRow = FirstRow.cellIterator();
				int k = 0;
				int TC_Column = 0;
				while (CellsofFirstRow.hasNext()) {
					Cell CellValue = CellsofFirstRow.next();
					if (CellValue.getStringCellValue().equalsIgnoreCase("TestCaseName")) {
						TC_Column = k;
						// System.out.println("expected column for test case name:" + k);
						break;
					}
					k++;
				}

				// verify the row where the desired test case is found and fetch the entire row
				while (Rows.hasNext()) {
					Row Datarow = Rows.next();
					String TCName = Datarow.getCell(TC_Column).getStringCellValue();
					// Datarow.getCell(TC_column).getNumericCellValue()
					if (TCName.equalsIgnoreCase(TestCaseName)) {
						Iterator<Cell> CellValues = Datarow.cellIterator();
						while (CellValues.hasNext()) {
							String Data = "";
							Cell CurrentCell = CellValues.next();
							try {
								String StringData = CurrentCell.getStringCellValue();
								Data = StringData;
							} catch (IllegalStateException e) {
								double doubledata = CurrentCell.getNumericCellValue();
								Data = Double.toString(doubledata);
							}

							ArrayData.add(Data);
						}
						break;
					}
				}

			}
		}
		return ArrayData;

	}
}
