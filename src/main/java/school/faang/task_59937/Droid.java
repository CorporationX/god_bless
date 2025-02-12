package school.faang.task_59937;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Droid {
    private static final int ALPHABET_LETTERS_COUNT = 26;
    private final String name;

    public String encryptMessage(String message, int encryptionKey) {
        return caesarCipherAlgorithm(message, encryptionKey, getEncryptionKeyShift(encryptionKey));
    }

    public String decryptMessage(String message, int decryptionKey) {
        return caesarCipherAlgorithm(message, decryptionKey, getDecryptionKeyShift(decryptionKey));
    }

    public String caesarCipherAlgorithm(String message, int encryptionKey, int shift) {
        DroidMessageEncryptor cryptoAlgorithm = (m, e) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : m.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    encryptedMessage.append((char) ((ch - base + shift) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return cryptoAlgorithm.messageCryptoAlgorithm(message, encryptionKey);
    }

    public void sendMessage(Droid droidRecepient, String message, int encryptionKey) {
        String encrypted = encryptMessage(message, encryptionKey);
        System.out.printf("%s sent encrypted message: %s\n", this.name, encrypted);
        droidRecepient.receiveMessage(encrypted, encryptionKey);
    }

    public void receiveMessage(String encryptedMessage, int decryptionKey) {
        String decrypted = decryptMessage(encryptedMessage, decryptionKey);
        System.out.printf("%s get decrypted message: %s\n", this.name, decrypted);
    }

    private int getDecryptionKeyShift(int decryptionKey) {
        return ALPHABET_LETTERS_COUNT - decryptionKey;
    }

    private int getEncryptionKeyShift(int encryptionKey) {
        return encryptionKey;
    }
}
