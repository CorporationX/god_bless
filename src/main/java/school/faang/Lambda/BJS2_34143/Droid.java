package school.faang.Lambda.BJS2_34143;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

    public Droid(String name) {
        this.name = name;
    }

    private DroidMessageEncryptor encryptor = (message, key) -> {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + key) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    };

    private DroidMessageEncryptor decryptor = (message, key) -> {
        return encryptor.process(message, 26 - key);
    };

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " отправляет зашифрованное сообщение: " + encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(name + " получил и расшифровал сообщение: " + decryptedMessage);
    }

    private String encryptMessage(String message, int key) {
        return encryptor.process(message, key);
    }

    private String decryptMessage(String message, int key) {
        return decryptor.process(message, key);
    }
}
