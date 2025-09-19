package school.faang.sprint2.droid;

import static java.awt.SystemColor.text;

public class Droid {
    private String name;

    public Droid(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (text, shiftKey) -> {
            StringBuilder result = new StringBuilder();
            for (char character : text.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isLowerCase(character) ? 'a' : 'A';

                    char encryptedChar = (char) ((character - base + shiftKey) % 26 + base);
                    result.append(encryptedChar);
                } else {
                    result.append(character);
                }
            }
            return result.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        return encryptMessage(encryptedMessage, -key);
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);

        System.out.println(this.name + " отправил зашифрованное сообщение: " + encryptedMessage);

        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);

        System.out.println(this.name + " получил расшифрованное сообщение: " + decryptedMessage);
    }
}
