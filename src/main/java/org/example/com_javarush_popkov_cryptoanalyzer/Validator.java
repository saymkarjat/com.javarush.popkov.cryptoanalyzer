package org.example.com_javarush_popkov_cryptoanalyzer;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    public static boolean isValidKey(int key) {
        // Проверка ключа
        return Cipher.ALPHABET.length <= key;

    }
    public static boolean isFileExists(String filePath) {
        // Проверка существования файла
        if(Files.exists(Path.of(filePath))){
            return true;
        }
        else return false;

    }
}
