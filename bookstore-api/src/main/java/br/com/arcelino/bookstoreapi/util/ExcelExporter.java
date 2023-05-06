package br.com.arcelino.bookstoreapi.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelExporter<T> {
    private final XSSFWorkbook workbook = new XSSFWorkbook();
    private final XSSFSheet sheet;
    private final List<T> data;
    private final String[] columns;

    public ExcelExporter(List<T> data, String[] columns, String sheetName) {
        this.data = data;
        this.columns = columns;
        sheet = workbook.createSheet(Optional.ofNullable(sheetName).orElse("Dados"));
    }

    public void writeHeaderLine() {
        var row = sheet.createRow(0);

        var style = workbook.createCellStyle();
        var font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);
        style.setFont(font);

        for (int i = 0; i < columns.length; i++) {
            createCell(row, i, columns[i], style);
        }
    }

    public void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        var cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue(value.toString());
        }
        cell.setCellStyle(style);
    }

    public void writeDataLines() {
        var rowCount = 1;

        var style = workbook.createCellStyle();
        var font = workbook.createFont();
        font.setFontHeightInPoints((short) 14);
        style.setFont(font);

        for (var obj : data) {
            var row = sheet.createRow(rowCount++);
            var columnCount = 0;
            for (String columnName : columns) {
                try {
                    var getter = obj.getClass().getMethod("get" + capitalize(columnName));
                    var value = getter.invoke(obj);
                    createCell(row, columnCount++, value, style);
                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        var outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }

    private String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}