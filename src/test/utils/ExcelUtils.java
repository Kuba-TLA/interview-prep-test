package utils;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtils {
    public void temp() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/data/excel/data.xlsx";

        //to locate external file
        FileInputStream fileInputStream = new FileInputStream(path);

        //accessing existing excel workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //accessing Excel sheet
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        //accessing the row of the sheet
        //Row row = sheet.getRow(2);

        //accessing the cell in the row
        //Cell cell = row.getCell(1);

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()){
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.iterator();

            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                System.out.print(cell + " - " + cell.getCellType() + " | ");
            }
            System.out.print("\n");

            //System.out.println(row.getCell(3));
        }
    }

    public void temp2() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/data/excel/data.xlsx";

        //to locate external file
        FileInputStream fileInputStream = new FileInputStream(path);

        //accessing existing excel workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //accessing Excel sheet
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        //creating a row to write data
        Row row = sheet.createRow(sheet.getLastRowNum() + 1);

        //creating a cell to add data
        Cell cell = row.createCell(0);
        cell.setCellValue("James");

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
    }

    public static void main(String[] args) throws IOException {
//        String path = System.getProperty("user.dir") + "/src/test/data/excel/data.xlsx";
//
//        //to locate external file
//        FileInputStream fileInputStream = new FileInputStream(path);
//
//        //accessing existing excel workbook
//        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//
//        //accessing Excel sheet
//        XSSFSheet sheet = workbook.getSheet("Sheet1");
//
//        //creating a row to write data
//        Row row = sheet.createRow(sheet.getLastRowNum() + 1);
//
//        //creating a cell to add data
//        Cell cell = row.createCell(0);
//        cell.setCellValue("James");
//
//        FileOutputStream fileOutputStream = new FileOutputStream(path);
//        workbook.write(fileOutputStream);

        Faker faker = new Faker();

//        System.out.println(faker.name().firstName());
//        System.out.println(faker.name().lastName());
//        System.out.println(faker.phoneNumber().cellPhone());
//        System.out.println(faker.idNumber().ssnValid());
//        System.out.println(faker.number().numberBetween(2000, 100000));

        System.out.println(faker.internet().emailAddress());


    }


}
