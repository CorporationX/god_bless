package school.faang.droid;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Droid {
    private String name;

    public void sendMessage(Droid droid, String messageForEncrypt, int encryptionKey) {
        String encryptedMessage = droid.encryptMessage(messageForEncrypt, encryptionKey);
        System.out.println(this.getName() + " sent an encrypted message: " + encryptedMessage);
        droid.receiveMessage(encryptedMessage, encryptionKey);
    }

    private void receiveMessage(String encryptedMessage, int encryptionKey) {
        String decryptedMessage = this.decryptMessage(encryptedMessage, encryptionKey);
        System.out.println(this.getName() + " received the decrypted message: " + decryptedMessage);
    }

    private String encryptMessage(String encryptedMessage, int encryptionKey) {
        DroidMessageEncryptor<String, Integer> messageEncryptor = (message, key) -> {
            Character[] messageForEncrypted = message.chars()
                    .mapToObj(ch -> (char) ch)
                    .map(ch -> {
                        if (Character.isLetter(ch)) {
                            char base = (ch >= 'a') ? 'a' : 'A';
                            return (char) ((ch - base + key) % 26 + base);
                        }
                        return ch;
                    })
                    .toArray(Character[]::new);
            String result = Arrays.stream(messageForEncrypted)
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            return result;
        };
        return messageEncryptor.encryption(encryptedMessage, encryptionKey);
    }

    private String decryptMessage(String decryptedMessage, int encryptionKey) {
        DroidMessageEncryptor<String, Integer> messageDecryptor = (message, key) -> {
            Character[] messageForDecrypted = message.chars()
                    .mapToObj(ch -> (char) ch)
                    .map(ch -> {
                        if (Character.isLetter(ch)) {
                            char base = (ch >= 'a') ? 'a' : 'A';
                            return (char) ((ch - base - key + 26) % 26 + base);
                        }
                        return ch;
                    })
                    .toArray(Character[]::new);
            String result = Arrays.stream(messageForDecrypted)
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            return result;
        };
        return messageDecryptor.encryption(decryptedMessage, encryptionKey);
    }
}
