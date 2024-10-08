package secrets_of_the_droids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import secrets_of_the_droids.interfaces.DroidMessageEncryptor;

@Getter
@AllArgsConstructor
public class Droid {
    private final String name;
    private final int THE_NUMBER_OF_LETTERS_IN_THE_ALPHABET = 26;

    /**
     * Encrypts a message by replacing each letter with the letter
     * <code>encryptionKey</code> positions down the alphabet.
     *
     * @param message the message to encrypt
     * @param encryptionKey the key to use for encryption
     * @return the encrypted message
     */
    private String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> encrypt(message, encryptionKey);
        return encryptor.encrypt(message, encryptionKey);
    }

    /**
     * Decrypts a message that was encrypted by replacing each letter with the letter
     * <code>encryptionKey</code> positions down the alphabet.
     *
     * @param message the message to decrypt
     * @param encryptionKey the key to use for decryption
     * @return the decrypted message
     */
    private String decryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor decryptor = (msg, key) -> encrypt(
                message,
                THE_NUMBER_OF_LETTERS_IN_THE_ALPHABET - (encryptionKey % THE_NUMBER_OF_LETTERS_IN_THE_ALPHABET)
        );
        return decryptor.encrypt(message, encryptionKey);
    }

    /**
     * Encrypts a message by replacing each letter with the letter
     * <code>encryptionKey</code> positions down the alphabet.
     *
     * @param message the message to encrypt
     * @param encryptionKey the key to use for encryption
     * @return the encrypted message
     */
    private String encrypt(String message, int encryptionKey) {
        StringBuilder encryptedText = new StringBuilder();
        encryptionKey = encryptionKey % THE_NUMBER_OF_LETTERS_IN_THE_ALPHABET;
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char shiftedChar = (char) ((c - base + encryptionKey) % THE_NUMBER_OF_LETTERS_IN_THE_ALPHABET + base);
                encryptedText.append(shiftedChar);
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }

    /**
     * Sends a message to the specified droid, encrypting the message first with the specified key.
     *
     * @param droid the droid to send the message to
     * @param message the message to send
     * @param encryptionKey the key to encrypt the message with
     */
    public void sendMessage(Droid droid, String message, int encryptionKey) {
        String encryptMessage =  encryptMessage(message, encryptionKey);
        System.out.printf("%s отправил зашифрованное сообщение: %s%n", getName(), encryptMessage);

        droid.receiveMessage(encryptMessage, encryptionKey);
    }

    /**
     * Decrypts the message and prints it to the console.
     *
     * @param encryptedMessage the encrypted message to decrypt and print
     * @param encryptionKey the key to decrypt the message with
     */
    public void receiveMessage(String encryptedMessage, int encryptionKey) {
        String decryptedMessage = decryptMessage(encryptedMessage, encryptionKey);
        System.out.printf("%s получил расшифрованное сообщение: %s%n", getName(), decryptedMessage);
    }
}
