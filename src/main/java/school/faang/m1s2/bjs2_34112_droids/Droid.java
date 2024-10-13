package school.faang.m1s2.bjs2_34112_droids;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private static final int ALPHABET_LENGHT = 26;
    private static final int FIRST_CHAR_OF_ALPHABET = 97;
    private static final int LAST_CHAR_OF_ALPHABET = 122;

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
                originalArray[i] = convertChar(originalArray[i], key);
                originalArray[i] = Character.toUpperCase(originalArray[i]);
            } else {
                originalArray[i] = convertChar(originalArray[i], key);
            }
        }
        return new String(originalArray);
    }

    private char convertChar(char character, int key) {
        key = key % ALPHABET_LENGHT;
        if (Character.isLetter(character)) {
            char modified = (char) (character + key);
            if (modified >= FIRST_CHAR_OF_ALPHABET && modified <= LAST_CHAR_OF_ALPHABET) {
                return modified;
            } else if (modified > LAST_CHAR_OF_ALPHABET) {
                return (char) ((FIRST_CHAR_OF_ALPHABET - 1) + (modified - LAST_CHAR_OF_ALPHABET));
            } else if (modified < FIRST_CHAR_OF_ALPHABET) {
                return (char) ((LAST_CHAR_OF_ALPHABET + 1) - (FIRST_CHAR_OF_ALPHABET - modified));
            }
        }
        return character;
    }
}


