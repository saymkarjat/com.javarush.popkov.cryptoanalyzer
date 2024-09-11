package org.example.com_javarush_popkov_cryptoanalyzer;

import java.util.ArrayList;
import java.util.Collections;

public class BruteForce {
    public static String decryptByBruteForce(String s) {
        // Логика brute force
        ArrayList<Integer> matches = new ArrayList<>();

        for (int i = 1; i <= Cipher.ALPHABET.length; i++) {
            String temp = Cipher.decrypt(s,i);

        }
        int maxValue = Collections.max(matches);


        return Cipher.decrypt(s,1);
    }
}