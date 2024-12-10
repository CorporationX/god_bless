package school.faang.task46202;

import lombok.Getter;

@Getter
public class Droid {
    private static final int ALPHABET_SIZE = 26;

    private final String name;
    private static DroidMessageEncryptor decryptor = (newMessage, keyDecrypt) -> {
        StringBuilder result = new StringBuilder();

        for (char c : newMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base - keyDecrypt + ALPHABET_SIZE) % ALPHABET_SIZE + base));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    };
    private static DroidMessageEncryptor encryptor = (newMessage, keyEncrypt) -> {

        StringBuilder result = new StringBuilder();

        for (char c : newMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + keyEncrypt) % ALPHABET_SIZE + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    };

    public Droid(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name can`t be null");
        }
        this.name = name;
    }

    private void validateMessageKey(String string, int key) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("String can`t be null");
        }
        if (key < 0 || key > 26) {
            throw new IllegalArgumentException("the key must be in the range from 0 to 26");
        }
    }

    private String encryptMessage(String string, int key) {
        validateMessageKey(string, key);

        return encryptor.encrypt(string, key);
    }

    private String decryptMessage(String string, int key) {
        validateMessageKey(string, key);

        return decryptor.encrypt(string, key);
    }

    public void sendMessage(String message, int key, Droid droid) {
        validateMessageKey(message, key);
        if (droid == null) {
            throw new IllegalArgumentException("droid can`t be null");
        }

        String encryptMessage = encryptMessage(message, key);
        System.out.printf("%s отправил зашифрованное сообщение: %s%n", this.getName(), encryptMessage);
        System.out.printf("%s %s%n", droid.getName(), receiveMessage(encryptMessage, key));
    }

    private String receiveMessage(String message, int key) {
        validateMessageKey(message, key);

        String decryptMessage = decryptMessage(message, key);

        return String.format("получил расшифрованное сообщение: %s", decryptMessage);
    }
}
