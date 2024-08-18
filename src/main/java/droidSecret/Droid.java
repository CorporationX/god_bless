package droidSecret;

import java.util.HashMap;
import java.util.Map;

public class Droid {

    public static String sendEncryptMessage(String message, int code) {
        DroidMessageEncryptor droidMessageEncryptor = (message1, code1) -> {
          String s = encrypt(message1, code1);
            System.out.println(s);
          return s;
        };

       return droidMessageEncryptor.encrypt(message, code);
    }

    public static String receiveEncryptMessage(String message, int code) {
        DroidMessageEncryptor droidMessageEncryptor = (message1, code1) -> {
            String s = unEncrypt(message1, code1);
            System.out.println(s);
            return s;
        };
        return droidMessageEncryptor.encrypt(message, code);
    }

    public static String encrypt(String message, int code) {
        StringBuilder builder = new StringBuilder();

        for (char ch : message.toCharArray()) {
        if (Character.isLetter(ch)) {
            char base = Character.isLowerCase(ch) ? 'a' : 'A';
            char codeChar = (char) ((ch - base + code) % 26 + base);
            builder.append(codeChar);
        } else {
            builder.append(ch);
        }
        }
       return builder.toString();
    }

    public static String unEncrypt(String message, int code) {
        StringBuilder builder = new StringBuilder();

        for(char ch : message.toCharArray()) {
            if(Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                char codeChar = (char)((ch - base - code + 26) % 26 + base);
                builder.append(codeChar);
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

}
