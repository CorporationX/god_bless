package school.faang.bjs2_80202;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {

    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, shift) -> {
            StringBuilder result = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char shifted = (char) ((c - base + shift) % 26 + base);
                    result.append(shifted);
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        };
        return encryptor.apply(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (msg, shift) -> {
            StringBuilder result = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char shifted = (char) ((c - base - shift + 26) % 26 + base);
                    result.append(shifted);
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        };
        return decryptor.apply(message, key);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(this.name + " отправил зашифрованное сообщение: " + encryptedMessage);
        recipient.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(this.name + " получил расшифрованное сообщение: " + decryptedMessage);
    }
}
