package faang.school.godbless.Droids;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Droid {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public String sendEncryptedMessage(String message, int key) {
        if (message.isBlank() || key<=0 || key>26) throw new IllegalArgumentException("invalid args");
        DroidMessageEncryptor encryptor = (message1, key1) -> {
            return encryptMessage(message1, key1);
        };
        return encryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        if (message.isBlank() || key<=0 || key>26) throw new IllegalArgumentException("invalid args");
        DroidMessageEncryptor decryptor = (message1, key1) -> {
            return decryptMessage(message1, key1);
        };
        return decryptor.encrypt(message, key);
    }

    public static String encryptMessage(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i<message.length(); i++) {
            for (int j=0; j<=25; j++) {
                if (message.charAt(i) == ALPHABET.charAt(j))  {
                    result.append(ALPHABET.charAt((j + key) % 26));
                    break;
                }
            }
        }
        return String.valueOf(result);
    }

    public static String decryptMessage(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i<message.length(); i++) {
            for (int j=0; j<=25; j++) {
                if (message.charAt(i) == ALPHABET.charAt(j))  {
                    result.append(ALPHABET.charAt((j - key + 26) % 26));
                    break;
                }
            }
        }
        return String.valueOf(result);
    }

}
