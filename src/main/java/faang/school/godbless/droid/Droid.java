package faang.school.godbless.droid;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Droid {
    public void sendEncryptedMessage(Droid receiver, String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (Character ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    int offset = ch - base;
                    int newOffset = (key + offset) % 26;
                    char newChar = (char) (base + newOffset);
                    encryptedMessage.append(newChar);
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        String encryptedMessage = encryptor.apply(message, encryptionKey);
        receiver.receiveEncryptedMessage(encryptedMessage, encryptionKey);
    }

    public void receiveEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor decryptor = (msg, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (Character ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    int offset = ch - base;
                    int newOffset = (offset - key + 26) % 26;
                    char newChar = (char) (base + newOffset);
                    decryptedMessage.append(newChar);
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        String decryptedMessage = decryptor.apply(message, encryptionKey);
        System.out.println(decryptedMessage);
    }
}
