package school.faang.bjs2_80494;

import lombok.Getter;

import java.util.function.Consumer;

public class Droid {
    @Getter
    private String name;
    private DroidMessageEncryptor caesarEncryptor = (message, keyEncryption) -> {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) (((c - 'A' + keyEncryption + 26) % 26) + 'A'));
            } else if (Character.isLowerCase(c)) {
                result.append((char) (((c - 'a' + keyEncryption + 26) % 26) + 'a'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    };

    public Droid(String name) {
        this.name = name;
    }

    public String encryptMessage(String message, int key) {
        return caesarEncryptor.apply(message, key);
    }

    public String decryptMessage(String message, int key) {
        return caesarEncryptor.apply(message, -key);
    }

    private String receiveMessage(String message, int key) {
        return decryptMessage(message, key);
    }

    public String sendMessage(String message, int key, Droid droid) {
        Consumer<String> consumer1 = string ->
                System.out.println(getName() + " отправил зашифрованное сообщение: " + message);
        consumer1.accept(message);
        String newMessage = encryptMessage(message, key);
        Consumer<String> consumer2 = string ->
                System.out.println(droid.getName() + " получил расшифрованное сообщение: " + newMessage);
        consumer2.accept(message);
        return receiveMessage(newMessage, key);

    }
}