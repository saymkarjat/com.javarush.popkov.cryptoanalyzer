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
        return crypt(text, shift, 1);
    }

    public static String decrypt(String text, int shift) {
        return crypt(text, shift, -1);
    }

    public static String crypt(String text, int shift, int factor){
        // Логика
        if (Validator.isValidKey(shift)){
            fillTheMap();
            StringBuilder encryptString = new StringBuilder();
            for (Character c : text.toCharArray()) {
                if (alphabetMap.containsKey(c)) {
                    int initialIndex = alphabetMap.get(c);
                    int targetIndex = (initialIndex + shift*factor) % ALPHABET.length;
                    if (targetIndex < 0){
                        targetIndex = ALPHABET.length + targetIndex;
                    }
                    c = ALPHABET[targetIndex];
                    encryptString.append(c);
                    //проверка если буква является заглавной
                } else if (alphabetMap.containsKey(Character.toLowerCase(c))) {
                    int initialIndex = alphabetMap.get(Character.toLowerCase(c));
                    int targetIndex = (initialIndex + shift*factor) % ALPHABET.length;
                    if (targetIndex < 0){
                        targetIndex = ALPHABET.length + targetIndex;
                    }
                    c = Character.toUpperCase(ALPHABET[targetIndex]);
                    encryptString.append(c);
                } else encryptString.append(c);
            }

            return encryptString.toString();
        }
        else throw new InvalidEncryptionKeyException("ключ не подходит");
    }



}
