package org.example.com_javarush_popkov_cryptoanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileManager {
     public static String DIRECTORY_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "output_text";

    public static String readFile(String filePath) {
        // Логика чтения файла|
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
       try(Scanner scn = new Scanner(file)){
        while (scn.hasNextLine()) {
            stringBuilder.append(scn.nextLine());
        }
       }
       catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       }
        return stringBuilder.toString();
    }
    public static String writeFile(String content, String directoryPath) {
        // Логика записи файла
        try {
            // Формируем уникальное имя файла с использованием текущего времени
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = "output_" + timestamp + ".txt";  // Можно изменить префикс "output_"

            // Путь до нового файла
            Path filePath = Path.of(directoryPath, fileName);

            // Запись содержимого в новый файл
            Files.writeString(filePath, content.replace("\n", System.lineSeparator()), StandardCharsets.UTF_8);
            return filePath.toAbsolutePath().toString();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи файла", e);
        }
    }
}