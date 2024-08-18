package faang.school.godbless.BJS2_20982;

import lombok.Getter;

@Getter
public class Droid {

    private String message;
    private int key;

    public String sendEncryptedMessage(String message, Integer key){
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    char encryptedChar = (char) ((ch - base + k) % 26 + base);
                    encrypted.append(encryptedChar);
                } else {
                    encrypted.append(ch);
                }
            }
            return encrypted.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String encryptedMsg, Integer key){
        DroidMessageEncryptor decryptor = (msg, k) -> {
            StringBuilder decrypted = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    char decryptedChar = (char) ((ch - base - k + 26) % 26 + base);
                    decrypted.append(decryptedChar);
                } else {
                    decrypted.append(ch);
                }
            }
            return decrypted.toString();
        };
        return decryptor.encrypt(encryptedMsg, key);
    }
}
