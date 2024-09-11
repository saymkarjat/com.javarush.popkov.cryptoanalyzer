package org.example.com_javarush_popkov_cryptoanalyzer;

import java.util.HashMap;
import java.util.Map;

public class Cipher {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static final Map<Character, Integer> alphabetMap = new HashMap<>();

    private static void fillTheMap(){
        for (int i = 0; i < ALPHABET.length; i++) {
            alphabetMap.put(ALPHABET[i], i);
        }
    }


    public static String encrypt(String text, int shift) {
        // Логика шифрования
        if (Validator.isValidKey(shift)){
            fillTheMap();
            StringBuilder encryptString = new StringBuilder();
            for (Character c : text.toCharArray()) {
                if (alphabetMap.containsKey(c)) {
                    int initialIndex = alphabetMap.get(c);
                    c = ALPHABET[(initialIndex + shift) % ALPHABET.length];
                    encryptString.append(c);
                    //проверка если буква является заглавной
                } else if (alphabetMap.containsKey(Character.toLowerCase(c))) {
                    int initialIndex = alphabetMap.get(Character.toLowerCase(c));
                    c = Character.toUpperCase(ALPHABET[(initialIndex + shift) % ALPHABET.length]);
                    encryptString.append(c);
                } else encryptString.append(c);
            }

            return encryptString.toString();
        }
        else throw new InvalidEncryptionKeyException("ключ не подходит");
    }

    public static String decrypt(String encryptedText, int shift) {
        // Логика расшифровки
        if (Validator.isValidKey(shift)){
            fillTheMap();
            StringBuilder decryptString = new StringBuilder();
            for (Character c : encryptedText.toCharArray()) {
                if (alphabetMap.containsKey(c)) {
                    int initialIndex = alphabetMap.get(c);
                    c = ALPHABET[(ALPHABET.length + initialIndex - shift) % ALPHABET.length];
                    decryptString.append(c);
                    //проверка если буква является заглавной
                } else if (alphabetMap.containsKey(Character.toLowerCase(c))) {
                    int initialIndex = alphabetMap.get(Character.toLowerCase(c));
                    c = Character.toUpperCase(ALPHABET[(ALPHABET.length + initialIndex - shift) % ALPHABET.length]);
                    decryptString.append(c);
                } else decryptString.append(c);
            }

            return decryptString.toString();
        }
        else throw new InvalidEncryptionKeyException("ключ не подходит");
    }



}
