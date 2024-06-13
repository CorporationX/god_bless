package faang.school.godbless.Droids;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Droid {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public String sendEncryptedMessage(String message, int key) {
        if (message.isBlank() || key<=0 || key>26) throw new IllegalArgumentException("invalid args");
        DroidMessageEncryptor encryptor = (message1, key1) -> {
            StringBuilder result = new StringBuilder();
            for (int i=0; i<message1.length(); i++) {
                for (int j=0; j<=25; j++) {
                    if (message1.charAt(i) == ALPHABET.charAt(j))  {
                        result.append(ALPHABET.charAt((j + key1) % 26));
                        break;
                    }
                }
            }
            return String.valueOf(result);
        };
        return encryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        if (message.isBlank() || key<=0 || key>26) throw new IllegalArgumentException("invalid args");
        DroidMessageEncryptor decryptor = (message1, key1) -> {
            StringBuilder result = new StringBuilder();
            for (int i=0; i<message1.length(); i++) {
                for (int j=0; j<=25; j++) {
                    if (message1.charAt(i) == ALPHABET.charAt(j))  {
                        result.append(ALPHABET.charAt((j - key1 + 26) % 26));
                        break;
                    }
                }
            }
            return String.valueOf(result);
        };
        return decryptor.encrypt(message, key);
    }

}
