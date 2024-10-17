package mod1sp12.secretsOfDroids;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;
    private static final int ENG_ALPHABET_SIZE = 26;

    private static final DroidMessageEncryptor ENCRYPTOR = (msg, encryptKey) -> {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char ch : msg.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                encryptedMessage.append((char) ((ch - base + encryptKey) % ENG_ALPHABET_SIZE + base));
            } else {
                encryptedMessage.append(ch);
            }
        }
        return encryptedMessage.toString();
    };

    private static final DroidMessageEncryptor DECRYPTOR = (msg, decryptionKey) -> {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char ch : msg.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                decryptedMessage.append((char) ((ch - base - decryptionKey + ENG_ALPHABET_SIZE) % ENG_ALPHABET_SIZE + base));
            } else {
                decryptedMessage.append(ch);
            }
        }
        return decryptedMessage.toString();
    };

    private String encryptMessage(String message, int key) {
        return ENCRYPTOR.encrypt(message, key);
    }
    
    private String decryptMessage(String message, int key) {
        return DECRYPTOR.encrypt(message, key);
    }

    public void sendMessage(Droid droid, String message, int encryptionKey) {
        String enryptedMessage = encryptMessage(message, encryptionKey);
        System.out.printf("\n" + this.name + " отправил зашифрованное сообщение: " + enryptedMessage + "\n");
        receiveMessage(droid, enryptedMessage, encryptionKey);
    }

    public void receiveMessage(Droid droid, String encryptedMessage, int decryptionKey) {
        System.out.printf(droid.name + " получил расшифрованное сообщение: " + decryptMessage(encryptedMessage, decryptionKey));
    }
}