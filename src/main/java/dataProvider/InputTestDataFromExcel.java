package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class InputTestDataFromExcel {
	

	@DataProvider( name = "testdata")
	public String[][] testDataFromExcel() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Authanticate_TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int totalNumberOfRows = sheet.getLastRowNum();
		//System.out.println(totalNumberOfRows);
		int totalNumberOfCollumn = sheet.getRow(1).getLastCellNum();
		//System.out.println(totalNumberOfCollumn);
		String [][] exceldata = new String [totalNumberOfRows][totalNumberOfCollumn];
		for (int i=0;i<totalNumberOfRows-1;i++) {
			//XSSFRow presentRow = sheet.getRow(i+1);
			for(int j =0;j<totalNumberOfCollumn;j++) {
				//presentRow.getCell(j).getRawValue();
				//XSSFRow presentRow = sheet.getRow(i+1);
				//XSSFCell presentCell = presentRow.getCell(j);
				//exceldata [i][j]=  presentCell.toString();
				DataFormatter cleanData = new DataFormatter();
				exceldata[i][j] = cleanData.formatCellValue(sheet.getRow(i+1).getCell(j));
				//System.out.print(presentCell.toString()+"\t");
			}
			//System.out.println();
		}
		workbook.close();
		file.close();
		
		//for (String[] dataArr : exceldata) {
			//System.out.println(Arrays.toString(dataArr));

		return exceldata;
		}
	}
