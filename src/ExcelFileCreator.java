import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * Import Apache Poi
 */

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileCreator {

    /**
     *
     *
     * @param listofLists list of lists welche die Zeilen der Tabelle enthalten
     * @param url url aus der kopiert werden soll
     * @param fileName name unter dem die Excel Datei abgespeichert werden soll
     */

    public void excelFileCreation(List<List<String>> listofLists, String url, String fileName) {

        //Blank woorkbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Dow Jones Data");

        //Tabellenkopf
        List<String> headerList = new ArrayList<>(List.of("Name","Branche","Logo","Indexgewichtung in %","Aufnahme"));

        //Add Tabellenkopf zu listofList
        listofLists.add(0,headerList);

        //Zähler für die Zeilen
        int rowNum = 0;

        //Erster for loop iteriert durch die listofList-> Jedes Element darin entspricht einer Zeile
        for(List<String> list: listofLists) {
            //Jedes mal wird eine neue Zeile erzeugt
            Row row = sheet.createRow(rowNum++);


            int cellNum = 0; //Counter Zähler


            //Zweiter for loop iteriert durch die Zeile welche eine List<String> ist
            for (String e : list) {
                Cell cell = row.createCell(cellNum++); //Neue Zeile wird erzeugt
                cell.setCellValue(e); //Zeile wird mit entsprechendem Wert "gefüllt"
            }

        }
        /**
         * Create actual excel file
         */

        try{
            //Bin mir nicht 100% wie das funktioniert, aber hier wird Excel File erzeugt
            //".xlsx" endung damit ein Excel file erzeugt wird
            FileOutputStream outputStream = new FileOutputStream(new File(fileName+".xlsx"));


            workbook.write(outputStream); //Ich nehme an das workbook wird in das File geschrieben?
            outputStream.close(); //Nicht sicher wieso, das gemacht werden muss
            System.out.println(fileName+".xlsx has been created succesfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
