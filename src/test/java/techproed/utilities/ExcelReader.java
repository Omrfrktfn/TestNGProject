package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    Workbook workbook;
    Sheet sheet;

    public ExcelReader(String pathFile, String fileName){

        try {
            FileInputStream fis = new FileInputStream(pathFile);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //satir ve sutun sayilarini girdigimde, o hucredeki veriyi return eder
    public String getCellData(int row, int column){
        Cell cell = sheet.getRow(row).getCell(column);
        return cell.toString();
    }

    //Exceldeki satir sayisini return eder
    public int rowCount() {
        return sheet.getLastRowNum();
    }

}
