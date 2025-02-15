package school.faang.bjs2_57457;

import lombok.AllArgsConstructor;

import java.util.Objects;


@AllArgsConstructor
public class Droid {
    private final String name;

    public void sendMessage(Droid receiver, String message, int key) {
        String crypt = processMessage(message, key);
        System.out.println(this.name + " sent an encrypted message: " + crypt);
        receiver.receiveMessage(crypt, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = processMessage(message, -key);
        System.out.println(this.name + " received a decrypted message: " + decryptedMessage);
    }

    private String processMessage(String message, int key) {
        validateValue(message);
        validateAlphabet(message);

        DroidMessageEncryptor messageEncryptor = (m, k) -> {
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

        return messageEncryptor.apply(message, key);
    }

    private <T> void validateValue(T obj) {
        Objects.requireNonNull(obj, "Value cannot be null");
    }

    private void validateAlphabet(String message) {
        if (!message.matches("[a-zA-Z0-9\s.,!?]+")) {
            throw new IllegalArgumentException("Message may only contain English letters, numbers, spaces, and .,!?");
        }
    }
}

