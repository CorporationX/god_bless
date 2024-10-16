package school.faang.Lambda.BJS2_34143;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private static final int ALPHABET_SIZE = 26;
    private String name;

    public Droid(String name) {
        this.name = name;
    }

    private DroidMessageEncryptor encryptor = (message, key) -> {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + key) % ALPHABET_SIZE + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    };

    private DroidMessageEncryptor decryptor = (message, key) -> 
            encryptor.process(message, 26 - key);
    
    public String sendMessage(String message, int key) {
        return encryptMessage(message, key);
    }

    public String receiveMessage(String encryptedMessage, int key) {
        return decryptMessage(encryptedMessage, key);
    }

    private String encryptMessage(String message, int key) {
        return encryptor.process(message, key);
    }

    private String decryptMessage(String message, int key) {
        return decryptor.process(message, key);
    }
}
