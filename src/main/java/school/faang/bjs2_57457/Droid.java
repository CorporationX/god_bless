package school.faang.bjs2_57457;

import lombok.AllArgsConstructor;

import java.util.Objects;


@AllArgsConstructor
public class Droid {
    private final String name;

    public void sendMessage(Droid receiver, String message, int key) {
        String crypt = encryptMessage(message, key, true);
        System.out.println(this.name + " sent an encrypted message: " + crypt);
        receiver.receiveMessage(crypt, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = encryptMessage(message, key, false);
        System.out.println(this.name + " received a decrypted message: " + decryptedMessage);
    }

    private String encryptMessage(String message, int key, boolean flag) {
        validateValue(message);
        validateAlphabet(message);
        if (flag) {
            key %= 26;
            DroidMessageEncryptor encoder = (m, k) -> {
                StringBuilder sb = new StringBuilder();
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
        } else {
            key %= 26;
            DroidMessageEncryptor decoder = (m, k) -> {
                StringBuilder sb = new StringBuilder();
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
    }

    private <T> void validateValue(T obj) {
        Objects.requireNonNull(obj, "Value cannot be null");
    }

    private void validateAlphabet(String input) {
        if (!input.matches("[a-zA-Z\s]+")) {
            throw new IllegalArgumentException("Message must contain only English letters and spaces");
        }
    }
}

