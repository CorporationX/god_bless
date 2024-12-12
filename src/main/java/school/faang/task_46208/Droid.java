package school.faang.task_46208;


import java.util.Optional;
import java.util.stream.Collectors;

public class Droid {
    private final String name;

    public Droid(String name) {
        this.name = name;
    }

    public void sendMessage(Droid recipient, String message, int key) {
        key = validateKey(key);
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(this.name + " отправляет сообщение: " + encryptedMessage);
        recipient.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        key = validateKey(key);
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(this.name + " получил сообщение: " + decryptedMessage);
    }

    public String encryptMessage(String message, int key) {
        return message.chars()
                .mapToObj(ch -> encryptChar((char) ch, key))
                .collect(Collectors.joining());
    }

    public String decryptMessage(String encryptedMessage, int key) {
        return encryptedMessage.chars()
                .mapToObj(ch -> decryptChar((char) ch, key))
                .collect(Collectors.joining());
    }

    private String encryptChar(char ch, int key) {
        if (Character.isLetter(ch)) {
            char base = Character.isLowerCase(ch) ? 'a' : 'A';
            return Character.toString((char) ((ch - base + key) % 26 + base));
        } else {
            return Character.toString(ch);
        }
    }

    private String decryptChar(char ch, int key) {
        if (Character.isLetter(ch)) {
            char base = Character.isLowerCase(ch) ? 'a' : 'A';
            return Character.toString((char) ((ch - base - key + 26) % 26 + base));
        } else {
            return Character.toString(ch);
        }
    }

    private int validateKey(int key) {
        return Optional.of(key)
                .filter(k -> k > 0)
                .map(k -> k % 26)
                .orElseThrow(() -> new IllegalArgumentException("Ключ должен быть положительным!"));
    }
}
