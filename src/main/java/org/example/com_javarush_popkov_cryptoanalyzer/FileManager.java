package org.example.com_javarush_popkov_cryptoanalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileManager {
    public String readFile(String filePath) {
        // Логика чтения файла|
        try {
            return Files.readString(Path.of(filePath));
        } catch (NoSuchFileException e) {
            throw new RuntimeException("Файл не найден", e);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла", e);
        }
    }
    public String writeFile(String content, String directoryPath) {
        // Логика записи файла
        try {
            // Формируем уникальное имя файла с использованием текущего времени
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = "output_" + timestamp + ".txt";  // Можно изменить префикс "output_"

            // Путь до нового файла
            Path filePath = Path.of(directoryPath, fileName);

            // Запись содержимого в новый файл
            Files.writeString(filePath, content);
            return filePath.toAbsolutePath().toString();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи файла", e);
        }
    }
}