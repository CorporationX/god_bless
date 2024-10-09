package school.faang.droids_secrets;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private String name;
    private static final int NUMBER_OF_LETTERS_IN_THE_ALPHABET = 26;

    private String shiftMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder shiftedMessage = new StringBuilder();
            for (char ch : message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    int effectiveKey = (key % NUMBER_OF_LETTERS_IN_THE_ALPHABET + NUMBER_OF_LETTERS_IN_THE_ALPHABET)
                            % NUMBER_OF_LETTERS_IN_THE_ALPHABET;
                    shiftedMessage.append((char) ((ch - base + effectiveKey) % NUMBER_OF_LETTERS_IN_THE_ALPHABET + base));
                } else {
                    shiftedMessage.append(ch);
                }
            }
            return shiftedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String encryptMessage(String message, int key) {
        return shiftMessage(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        return shiftMessage(encryptedMessage, -key);
    }

    public void sendMessage(Droid droidReceiver, String message, int key) {
        String messageToSend = encryptMessage(message, key);
        System.out.println(this.getName() + " sent an encrypted message: " + messageToSend);
        droidReceiver.receiveMessage(messageToSend, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String messageToReceive = decryptMessage(encryptedMessage, key);
        System.out.println(this.getName() + " received a decrypted message: " + messageToReceive);
    }
}