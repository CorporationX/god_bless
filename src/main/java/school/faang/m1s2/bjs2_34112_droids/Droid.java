package school.faang.m1s2.bjs2_34112_droids;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private final String name;

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = encryptMessage(message, key, (m, k) -> cryptWithCaesarCipher(m, k, true));
        System.out.println(this.name + " sent encrypted message: " + encryptedMessage);
        receiveMessage(droid, encryptedMessage, key);
    }

    private void receiveMessage(Droid droid, String message, int key) {
        String decryptedMessage = decryptMessage(message, key, (m, k) -> cryptWithCaesarCipher(m, k, false));
        System.out.println(droid.name + " received decrypted message: " + decryptedMessage);
    }

    private String encryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        return encryptor.encrypt(message, key);
    }

    private String cryptWithCaesarCipher(String message, int key, boolean toCrypt) {
        if (!toCrypt) {
            key = -key;
        }

        char[] originalArray = message.toCharArray();

        for (int i = 0; i < message.length(); i++) {
            if (Character.isUpperCase(originalArray[i])) {
                originalArray[i] = Character.toLowerCase(originalArray[i]);
                originalArray[i] = charConvertor(originalArray[i], key);
                originalArray[i] = Character.toUpperCase(originalArray[i]);
            } else {
                originalArray[i] = charConvertor(originalArray[i], key);
            }
        }
        return new String(originalArray);
    }

    private char charConvertor(char c, int key) {
        if (Character.isLetter(c)) {
            char modified = (char) (c + key % 26);
            if (modified >= 97 && modified <= 122) {
                return modified;
            } else if (modified > 122) {
                return (char) (96 + (modified - 122));
            } else if (modified < 97) {
                return (char) (123 - (97 - modified));
            }
        }
        return c;
    }
}


