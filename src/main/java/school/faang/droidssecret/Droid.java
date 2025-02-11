package school.faang.droidssecret;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {

    private final String name;

    public void sendMessage(Droid droid, String inputMessage, int key) {
        if (droid == null || inputMessage == null) {
            return;
        }
        String outputMessage = encryptMessage(inputMessage, key);
        System.out.println("Дроид " + this.name + " отправил сообщение: " + outputMessage);
        receiveMessage(droid, outputMessage, key);
    }

    private void receiveMessage(Droid droid, String inputMessage, int key) {
        System.out.println("Дроид " + droid.getName() + " получил сообщение: " + decryptMessage(inputMessage, key));
    }

    private String encryptMessage(String inputMessage, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (message, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char inputSymbol = message.charAt(i);
                if (Character.isLetter(inputSymbol)) {
                    char base = Character.isLowerCase(inputSymbol) ? 'a' : 'A';
                    encryptedMessage.append((char) ((inputSymbol - base + encryptionKey) % 26 + base));
                } else {
                    encryptedMessage.append(inputSymbol);
                }
            }
            return encryptedMessage.toString();
        };
        return droidMessageEncryptor.encrypt(inputMessage, key);
    }

    private String decryptMessage(String inputMessage, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (message, decryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char inputSymbol = message.charAt(i);
                if (Character.isLetter(inputSymbol)) {
                    char base = Character.isLowerCase(inputSymbol) ? 'a' : 'A';
                    encryptedMessage.append((char) ((inputSymbol - base - decryptionKey + 26) % 26 + base));
                } else {
                    encryptedMessage.append(inputSymbol);
                }
            }
            return encryptedMessage.toString();
        };
        return droidMessageEncryptor.encrypt(inputMessage, key);
    }


}
