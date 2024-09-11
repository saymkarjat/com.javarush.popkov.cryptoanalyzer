package org.example.com_javarush_popkov_cryptoanalyzer;

import java.util.ArrayList;
import java.util.Collections;

public class BruteForce {
    public String decryptByBruteForce(String s) {
        // Логика brute force
        ArrayList<Integer> matches = new ArrayList<>();
        Cipher cipher = new Cipher();

        for (int i = 1; i <= Cipher.ALPHABET.length; i++) {
            String temp = cipher.decrypt(s,i);
            int count = 0;
            for (Character c : temp.toCharArray()) {
                if (c == 'и' || c == 'о' || c == 'а' || c == 'с') {
                    count++;
                }
            }

            matches.add(count);
        }
        int maxValue = Collections.max(matches);
        int key = matches.indexOf(maxValue) + 1;

        return cipher.decrypt(s,key);
    }
}