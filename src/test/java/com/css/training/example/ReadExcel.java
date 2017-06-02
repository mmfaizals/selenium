package com.css.training.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcel {

	public List<BiographySearchIO> getDataFromExcel() {
		ArrayList<BiographySearchIO> list = new ArrayList<BiographySearchIO>();
		try {
			InputStream file = getClass().getClassLoader().getResourceAsStream(
					"TestBio.xls");

			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);

			// Get iterator to all the rows in current sheet
			Iterator<Row> rows = sheet.iterator();
			int i = 0;
			while (rows.hasNext()) {
				if (i == 0) {
					continue;
				}
				i = i + 1;
				Row row = rows.next();
				BiographySearchIO in = new BiographySearchIO();
				in.qText = row.getCell(0).getStringCellValue();
				in.linkStarts = row.getCell(1).getStringCellValue();
				in.linkEnds = row.getCell(2).getStringCellValue();
				in.born = row.getCell(3).getStringCellValue();
				list.add(in);
			}
		} catch (IOException io) {
			throw new RuntimeException(io);
		}
		return list;

	}
}
