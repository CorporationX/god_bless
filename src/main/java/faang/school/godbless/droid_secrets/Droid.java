package faang.school.godbless.droid_secrets;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (messageToEncrypt, encryptionKey) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < messageToEncrypt.length(); i++) {
                char letter = messageToEncrypt.charAt(i);
                if (Character.isLetter(letter)) {
                    char start = 'a';
                    if (Character.isUpperCase(letter)) {
                        start = Character.toUpperCase(start);
                    }
                    // letter - start -> getting position in the alphabet relative to the "A" or "a" letter
                    // then adding the encryptionKey. If the letter is over 25 -> getting remainder by 26
                    // if the letter is less or equal to 25 -> getting remainder by 26 will not affect
                    // after that adding staring position of "A" or "a" to get needed char in unicode table
                    letter = (char) (((letter - start) + encryptionKey) % 26 + start);
                }
                result.append(letter);
            }
            return result.toString();
        };

        return encryptor.crypt(message, key);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (messageToDecrypt, encryptionKey) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < messageToDecrypt.length(); i++) {
                char letter = messageToDecrypt.charAt(i);
                if (Character.isLetter(letter)) {
                    char start = 'a';
                    if (Character.isUpperCase(letter)) {
                        start = Character.toUpperCase(start);
                    }
                    // letter - start -> getting position in the alphabet relative to the "A" or "a" letter
                    // then subtracting the encryptionKey. If the letter is less than 0 -> adding 26
                    // if the letter after adding is over 26-> getting remainder by 26, otherwise remainder will not affect
                    // after that adding staring position of "A" or "a" to get needed char in unicode table
                    letter = (char) (((letter - start) - encryptionKey + 26) % 26 + start);
                }
                result.append(letter);
            }
            return result.toString();
        };

        return decryptor.crypt(encryptedMessage, key);
    }
}
