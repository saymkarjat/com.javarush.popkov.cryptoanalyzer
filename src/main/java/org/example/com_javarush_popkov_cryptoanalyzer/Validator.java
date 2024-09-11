package org.example.com_javarush_popkov_cryptoanalyzer;

public class Validator {
    public boolean isValidKey(int key) {
        // Проверка ключа
        return Cipher.ALPHABET.length <= key;

    }
    public boolean isFileExists(String filePath) {
        // Проверка существования файла
        return true;
    }
}
