import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String urlBundesanzeiger = "https://www.bundesanzeiger.de/ebanzwww/wexsservlet";
        String urlWikipedia = "https://en.wikipedia.org/wiki/List_of_blogs";
        String urlWikiSANDP = "https://en.wikipedia.org/wiki/S%26P_500_Index";
        String urlBundesSpkAlt = "https://www.bundesanzeiger.de/ebanzwww/wexsservlet";
        String wikiHow = "https://de.wikihow.com/Auf-einem-Computer-den-Bass-einstellen";
        final String yahooDax = "https://de.finance.yahoo.com/quote/%5EGDAXI/components?p=%5EGDAXI";
        final String wikiDIJ = "https://de.wikipedia.org/wiki/Dow_Jones_Industrial_Average";

        /**
         *
         * Für Wikipedia DowJones Link
         * Kannst du mal ausprobieren mit dem wikiDIJ link, dass funktionert halbwegs
         */

        /*List<List<String>> listofListRows = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(wikiDIJ).get();

            Elements table = doc.select("table.wikitable");

            Element tableIndexWeight = table.get(15);




            for (int i = 1; i < 25; i++) {
                List<String> listRows = new ArrayList<>();
                Element row = tableIndexWeight.select(" tr").get(i);
                String rowString = row.text();
                for (int j = 0; j < 5; j++) {
                    Element column = row.select(" td").get(j);
                    String columnString = column.text();
                    //  System.out.println(columnString);
                    listRows.add(columnString);
                }
                listofListRows.add(listRows);


            }
            for (List<String> lists : listofListRows) {

                //System.out.println(lists);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/


        ExcelFileCreator excelFileCreator = new ExcelFileCreator();

        /**
         * Für Bundesanzeiger Sparkasse Altötting Mühldorf
         */

        try{

            //Document wird erzeugt und mit der Url verbunden; .get() ist wichtig
            Document doc = Jsoup.connect(urlBundesSpkAlt).get();


            //Es gibt Elements(mehrere Elemente) & Element(ein Element)
            Elements table = doc.select("table.layout"); //Bei der cssQuery scheitert es
            System.out.println(table);

            /** Dieser Teil soll durch die Tabelle iterieren und die Zeilen in einer List<String> abspeichern.
             Danach sollen die Zeilen einer List<List<String>> hinzugefügt werden.
             Diese Liste wird dann unten an den excelFileCreator "übergeben".
            */



        }catch (Exception e){
            e.printStackTrace();
        }


        //excelFileCreator.excelFileCreation(listofListRows,wikiDIJ,"DowJonesWikipediaExcel3");

    }

}
