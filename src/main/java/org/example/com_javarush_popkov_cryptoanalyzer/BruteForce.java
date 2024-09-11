package org.example.com_javarush_popkov_cryptoanalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BruteForce {
    public static List<String> substrings = Arrays.asList("СТ", "НО", "ЕН", "ТО", "НА", "ОВ", "НИ", "РА", "ВО", "КО",
            "СТО", "ЕНО", "НОВ", "ТОВ", "ОВО", "ОВА");

    public static String decryptByBruteForce(String s) {
        // Логика brute force
        ArrayList<Integer> matches = new ArrayList<>();


        for (int i = 1; i <= Cipher.ALPHABET.length; i++) {
            int count = 0;
            String temp = Cipher.decrypt(s, i);
            count = allMatches(temp.toUpperCase(), substrings);
            matches.add(count);
        }
        int max = Collections.max(matches);
        int key = matches.indexOf(max);
        return Cipher.decrypt(s, key + 1);
    }

    private static int countMatches(String text, String substring) {
        int count = 0;
        int index = 0;
        String ourText = text.toUpperCase();
        while ((index = ourText.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

    public static int allMatches(String text, List<String> substrings) {
        int count = 0;
        String ourText = text.toUpperCase();
        for (String string : substrings) {

            count += countMatches(ourText, string);
        }
        return count;
    }
}