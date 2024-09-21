package com.example.X_traktor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelJsonConvertor {
    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\HP\\Desktop\\file1.xlsx";
        try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
    Workbook workbook = new XSSFWorkbook(fis)) {

        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        JsonArray jsonArray = new JsonArray();

        for (Row row : sheet) {
            JsonObject jsonObject = new JsonObject();
            for (Cell cell : row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                jsonObject.addProperty("Column" + cell.getColumnIndex(), cellValue);
            }
            jsonArray.add(jsonObject);
        }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Object jsonObject = gson.fromJson(jsonArray, Object.class);
            String prettyJson = gson.toJson(jsonObject);

            System.out.println("Json Format A :" + prettyJson);
        String newline = System.lineSeparator();
        System.out.println("Json Format B :" + newline + jsonArray.toString() + newline);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
