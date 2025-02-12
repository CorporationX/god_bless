package school.faang.bjs2_57457;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class Droid {
    private final String name;

    public void sendMessage(Droid receiver, String message, int key) {
        String crypt = encryptMessage(message, key);
        System.out.println(this.name + " sent an encrypted message: " + crypt);
        receiver.receiveMessage(crypt, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println(this.name + " received a decrypted message: " + decryptedMessage);
    }

    private String encryptMessage(String message, int key) {
        validateValue(message, key);
        StringBuilder sb = new StringBuilder();
        key %= 26;
        DroidMessageEncryptor encoder = (m, k) -> {
            for (char c : m.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char shifted = (char) ((c - base + k + 26) % 26 + base);
                    sb.append(shifted);
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        };
        return encoder.apply(message, key);
    }

    private String decryptMessage(String message, int key) {
        validateValue(message, key);
        StringBuilder sb = new StringBuilder();
        key %= 26;
        DroidMessageEncryptor decoder = (m, k) -> {
            for (char c : m.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char shifted = (char) ((c - base - k + 26) % 26 + base);
                    sb.append(shifted);
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        };
        return decoder.apply(message, key);
    }

    private <T> void validateValue(T value, T expected) {
        if (value == null || expected == null) {
            throw new IllegalArgumentException("Value or expected");
        }
    }

    private <T> void validateValue(T obj, T value, T expected) {
        if (obj == null || value == null || expected == null) {
            throw new IllegalArgumentException("Value or expected");
        }
    }
}

