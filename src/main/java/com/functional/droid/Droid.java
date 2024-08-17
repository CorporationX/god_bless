package com.functional.droid;

public class Droid {

    public String sendEncryptedMessage(String message, int code) {
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            StringBuilder stringBuilder = new StringBuilder(message);
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (Character.isLetter(stringBuilder.charAt(i))) {
                    int temp = stringBuilder.charAt(i) + code;
                    if (temp > 'z') {
                        temp = code + 'a' - 1;
                    }
                    stringBuilder.setCharAt(i, (char) temp);
                }
            }
            return stringBuilder.toString();
        };
        return droidMessageEncryptor.encrypt(message, code);
    }

    public String receiveEncryptedMessage(String message, int code) {
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            StringBuilder stringBuilder = new StringBuilder(message);
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (Character.isLetter(stringBuilder.charAt(i))) {
                    int temp = stringBuilder.charAt(i) - code;
                    if (temp < 'A') {
                        temp = 'z' - code + 1;
                    }
                    stringBuilder.setCharAt(i, (char) temp);
                }
            }
            return stringBuilder.toString();
        };
        return droidMessageEncryptor.encrypt(message, code);
    }
}

