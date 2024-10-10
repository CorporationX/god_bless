package secretsOfDroids;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + encryptKey) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }
    
    private String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (msg, decryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - decryptionKey + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(message, key);
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