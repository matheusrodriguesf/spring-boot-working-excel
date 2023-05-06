package br.com.arcelino.bookstoreapi.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arcelino.bookstoreapi.service.LivroService;
import br.com.arcelino.bookstoreapi.util.ExcelExporter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService service;

    private static final String DATE_FORMAT = "dd-MM-yyyy_HH:mm:ss";

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        var formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        var currentDateTime = LocalDateTime.now().format(formatter);

        var headerKey = "Content-Disposition";
        var headerValue = "attachment; filename=livros_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        var livros = service.all();
        String[] columns = { "titulo", "descricao", "isbn", "autor", "editora", "ano" };
        var exporter = new ExcelExporter<>(livros, columns, "Livros");
        exporter.export(response);
    }

    @GetMapping("/export/excel/livros")
    public void exportToExcelLivros(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        var formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        var currentDateTime = LocalDateTime.now().format(formatter);

        var headerKey = "Content-Disposition";
        var headerValue = "attachment; filename=livros_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        var livros = service.getLivros();
        String[] columns = { "titulo", "isbn", "editora", "autor", "ano", "categoria" };
        var exporter = new ExcelExporter<>(livros, columns, "Livros");
        exporter.export(response);
    }
}