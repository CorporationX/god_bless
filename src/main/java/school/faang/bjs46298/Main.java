package school.faang.bjs46298;

import java.util.HashSet;

public class Main {
    public static int UPPER_CASE = 'A';
    public static int LOWER_CASE = 'a';

    public static void main(String[] args) {
        Droid droid = new Droid(new HashSet<>());
        Droid droid1 = new Droid(new HashSet<>());

        droid.setEncryptor((message, key) -> {
            StringBuilder original = new StringBuilder(message);
            StringBuilder encrypted = new StringBuilder(message.length());

            original.chars().forEach(utfNumber -> {
                char aChar = (char) utfNumber;
                if (Character.isAlphabetic(aChar)) {
                    int base = Character.isUpperCase(aChar) ? UPPER_CASE : LOWER_CASE;
                    aChar = (char) ((Character.toLowerCase(aChar) - LOWER_CASE + key) % 26 + base);
                }
                encrypted.append(aChar);
            });
            return encrypted.toString();
        });

        droid.setDecryptor((message, key) -> {
            StringBuilder original = new StringBuilder(message);
            StringBuilder decrypted = new StringBuilder(message.length());

            original.chars().forEach(utfNumber -> {
                char aChar = (char) utfNumber;
                if (Character.isAlphabetic(aChar)) {
                    int base = Character.isUpperCase(aChar) ? UPPER_CASE : LOWER_CASE;
                    aChar = (char) ((Character.toLowerCase(aChar) - LOWER_CASE - key + 26) % 26 + base);
                }
                decrypted.append(aChar);
            });
            return decrypted.toString();
        });

        droid1.setEncryptor(droid.getEncryptor());
        droid1.setDecryptor(droid.getDecryptor());

        droid.sendMessage(droid1, "Hello buddy", 3);
        System.out.println(droid1.getReceivedMessages().contains("Hello buddy"));
    }
}
