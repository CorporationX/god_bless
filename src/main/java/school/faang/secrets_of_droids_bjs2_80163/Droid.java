package school.faang.secrets_of_droids_bjs2_80163;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptMessage.append((char) ((ch - base + encryptionKey) % 26 + base));
                } else {
                    encryptMessage.append(ch);
                }
            }
            return encryptMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (msg, decryptionKey) -> {
            StringBuilder decryptMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptMessage.append((char) ((ch - base - decryptionKey + 26) % 26 + base));
                } else {
                    decryptMessage.append(ch);
                }
            }
            return decryptMessage.toString();
        };
        return decryptor.encrypt(message, key);
    }

    public void sendMessage(Droid reciever, String message, int key) {
        String encryptMessage = encryptMessage(message, key);
        System.out.printf("%s отправил зашифрованное сообщение %s\n", this.name, encryptMessage);
        reciever.recieveMessage(encryptMessage, key);
    }

    public void recieveMessage(String message, int key) {
        String decryptMessage = decryptMessage(message, key);
        System.out.printf("%s получил расшифрованное сообщение: %s\n", this.name, decryptMessage);
    }
}
