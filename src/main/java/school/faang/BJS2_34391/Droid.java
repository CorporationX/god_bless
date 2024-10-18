package school.faang.BJS2_34391;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    encrypted.append((char) (((c - base + k) % 26) + base)); // Исправлено
                } else {
                    encrypted.append(c);
                }
            }
            return encrypted.toString();
        };
        return encryptor.processMessage(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (msg, k) -> {
            StringBuilder decrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    decrypted.append((char) (((c - base - k + 26) % 26) + base));
                } else {
                    decrypted.append(c);
                }
            }
            return decrypted.toString();
        };
        return decryptor.processMessage(encryptedMessage, key);
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key); // Исправлено
        System.out.println(name + " отправил зашифрованное сообщение " + receiver.getName() + ": " + encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(name + " получил дешифрованное сообщение: " + decryptedMessage);
    }
}
