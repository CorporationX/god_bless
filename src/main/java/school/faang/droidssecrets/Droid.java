package school.faang.droidssecrets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, shiftKey) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    ch = (char) ((ch - base + shiftKey) % 26 + base);
                }
                encrypted.append(ch);
            }
            return encrypted.toString();
        };
        return encryptor.apply(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (msg, shiftKey) -> {
            StringBuilder decrypted = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    ch = (char) ((ch - base - shiftKey + 26) % 26 + base);
                }
                decrypted.append(ch);
            }
            return decrypted.toString();
        };
        return decryptor.apply(message, key);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(this.name + " sent an encrypted message: " + encryptedMessage);
        recipient.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(this.name + " received a decrypted message: " + decryptedMessage);
    }
}

