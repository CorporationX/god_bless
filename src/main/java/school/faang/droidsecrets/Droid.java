package school.faang.droidsecrets;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private final String name;

    private String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> {
            StringBuilder result = new StringBuilder();
            if (msg == null) {
                throw new RuntimeException("Null can't be encrypted");
            }
            for (char symbol : msg.toCharArray()) {
                if (Character.isLetter(symbol)) {
                    char base = Character.isLowerCase(symbol) ? 'a' : 'A';
                    result.append((char) ((symbol - base + key) % 26 + base));
                } else {
                    result.append(symbol);
                }
            }
            return result.toString();
        };
        return droidMessageEncryptor.encryptDroidMessage(message, encryptionKey);
    }

    private String decryptMessage(String message, int decryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> {
            StringBuilder result = new StringBuilder();
            if (msg == null) {
                throw new RuntimeException("Null can't be decrypted");
            }
            for (char symbol : msg.toCharArray()) {
                if (Character.isLetter(symbol)) {
                    char base = Character.isLowerCase(symbol) ? 'z' : 'Z';
                    result.append((char) ((symbol - base - key) % 26 + base));
                } else {
                    result.append(symbol);
                }
            }
            return result.toString();
        };
        return droidMessageEncryptor.encryptDroidMessage(message, decryptionKey);
    }

    public void sendMessage(Droid droid, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        System.out.printf("%s got an encrypted message: \"%s\" \n", droid.getName(), encryptedMessage);
    }

    public void receiveMessage(String message, int decryptionKey) {
        String decryptedMessage = decryptMessage(message, decryptionKey);
        System.out.printf("Now you can receive decrypted message: \"%s\" \n", decryptedMessage);
    }
}
