package school.faang.droidSecrets;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encyptKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + encyptKey) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        return encryptMessage(message, -key + 26);
    }

    public void sendMessage(String message, int key, Droid otherDroid) {
        String encryptedMsg = encryptMessage(message, key);
        String decryptedMsg = otherDroid.receiveMessage(encryptedMsg, key);
        System.out.println("Droid " + name + " sent encrypted message: " + encryptedMsg);
        System.out.println("Droid " + otherDroid.getName() + " received decrypted message: " + decryptedMsg);
    }

    public String receiveMessage(String encryptedMessage, int key) {
        return decryptMessage(encryptedMessage, key);
    }
}
