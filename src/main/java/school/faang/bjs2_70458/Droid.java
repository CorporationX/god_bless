package school.faang.bjs2_70458;

import lombok.Data;

@Data
public class Droid implements DroidMessageEncryptor {

    private final String name;

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
//        System.out.printf("%s отправил зашифрованное сообщение: %s\n", name, encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
//        System.out.printf("%s получил расшифрованное сообщение: %s\n", name, decryptedMessage);
    }

    @Override
    public String encryptMessage(String message, int encryptionKey) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (!Character.isLetter(c)) {
                continue;
            }
            int encryptedChar = (int) c + encryptionKey;
            System.out.printf("%c -> %d + %d -> %d", c, (int) c, encryptionKey, encryptedChar);
            if (encryptedChar <= 90) {
                // capital
            }
            if (encryptedChar >= 97) {
                // lower
            }
            if (encryptedChar > 90) {
                if (encryptedChar > 122) {
                    encryptedChar = 96 + (encryptedChar - 122);
                } else {
                    encryptedChar = 64 + (encryptedChar - 90);
                }
            }
            char encryptedAsciiChar = (char) encryptedChar;
            System.out.print(" -> " + encryptedChar);
            System.out.print(" -> " + encryptedAsciiChar + "\n");
            encryptedMessage.append(encryptedAsciiChar);
        }
        return encryptedMessage.toString();
    }

    public String decryptMessage(String message, int decipherKey) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (!Character.isLetter(c)) {
                continue;
            }
            int decryptedChar = (int) c - decipherKey;
            if (decryptedChar < 65) {
                decryptedChar = 91 - (65 - decryptedChar);
            } else if (decryptedChar < 97) {
                decryptedChar = 123 - (97 - decryptedChar);
            }
            char decryptedAsciiChar = (char) decryptedChar;
            encryptedMessage.append(decryptedAsciiChar);
        }
        return encryptedMessage.toString();
    }
}
