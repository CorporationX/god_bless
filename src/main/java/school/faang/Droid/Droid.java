package school.faang.Droid;

import lombok.Data;

@Data
public class Droid {
    private final String name;

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = encryptMessage(message, key, (msg, k) -> {
            StringBuilder result = new StringBuilder();
            for (char character : msg.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isLowerCase(character) ? 'a' : 'A';
                    result.append((char) ((character - base + k) % 26 + base));
                } else {
                    result.append(character);
                }
            }
            return result.toString();
        });
        System.out.println(this.name + " отправил зашифрованное сообщение: " + encryptedMessage);
        droid.receiveMessage(encryptedMessage, key);
    }

    private void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key, (msg, k) -> {
            StringBuilder result = new StringBuilder();
            for (char character : msg.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isLowerCase(character) ? 'a' : 'A';
                    result.append((char) ((character - base + k + 26) % 26 + base));
                } else {
                    result.append(character);
                }
            }
            return result.toString();
        });
        System.out.println(this.name + " получил расшифрованное сообщение: " + decryptedMessage);
    }

    private String encryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        return encryptor.apply(message, key);
    }

    private String decryptMessage(String message, int key, DroidMessageEncryptor decryptor) {
        return decryptor.apply(message, -key);
    }
}
