package org.example.com_javarush_popkov_cryptoanalyzer;

public class InvalidEncryptionKeyException extends RuntimeException{
    public InvalidEncryptionKeyException(String message) {
        super(message);
    }
}
