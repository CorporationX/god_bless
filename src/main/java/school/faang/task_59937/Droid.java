package school.faang.task_59937;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Droid {
    private static final int ALPHABET_SIZE = 26;
    private final String name;

    public String processMessage(String message, int key, ShiftStrategy strategy) {
        int shift = strategy.apply(key) % ALPHABET_SIZE;
        return applyCaesarCipher(message, shift);
    }

    private String applyCaesarCipher(String message, int shift) {
        shift = (shift % ALPHABET_SIZE + ALPHABET_SIZE) % ALPHABET_SIZE; // Нормализация сдвига
        StringBuilder result = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                int offset = (ch - base + shift) % ALPHABET_SIZE;
                result.append((char) (base + offset));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encrypted = processMessage(message, key, cryptoKey -> cryptoKey);
        System.out.printf("%s sent encrypted message: %s%n", this.name, encrypted);
        receiver.receiveMessage(encrypted, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decrypted = processMessage(encryptedMessage, key, cryptoKey -> ALPHABET_SIZE - cryptoKey);
        System.out.printf("%s decrypted message: %s%n", this.name, decrypted);
    }
}