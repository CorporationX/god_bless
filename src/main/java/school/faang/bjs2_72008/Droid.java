package school.faang.bjs2_72008;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Droid(String name) {
    private static final char UPPERCASE_A = 'A';
    private static final char LOWERCASE_A = 'a';
    private static final int ALPHABET_LENGTH = 26;

    public void sendMessage(Droid receiver, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        log.info("{} отправил зашифрованное сообщение: {}", this.name(), encryptedMessage);
        receiver.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String message, int encryptionKey) {
        String decryptedMessage = decryptMessage(message, encryptionKey);
        log.info("{} получил расшифрованное сообщение: {}", this.name(), decryptedMessage);
    }

    private String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor messageEncryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char chr : message.toCharArray()) {
                if (Character.isLetter(chr)) {
                    char baseLetter = Character.isUpperCase(chr) ? UPPERCASE_A : LOWERCASE_A;
                    int shift = (chr - baseLetter + key) % ALPHABET_LENGTH;
                    char encryptedChar = (char) (baseLetter + shift);
                    encryptedMessage.append(encryptedChar);
                } else {
                    encryptedMessage.append(chr);
                }
            }
            return encryptedMessage.toString();
        };

        return messageEncryptor.act(message, encryptionKey);
    }

    private String decryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor messageDecryptor = (msg, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char chr : message.toCharArray()) {
                if (Character.isLetter(chr)) {
                    char baseLetter = Character.isUpperCase(chr) ? UPPERCASE_A : LOWERCASE_A;
                    int shift = (chr - baseLetter - key + ALPHABET_LENGTH) % ALPHABET_LENGTH;
                    char decryptedChar = (char) (baseLetter + shift);
                    decryptedMessage.append(decryptedChar);
                } else {
                    decryptedMessage.append(chr);
                }
            }
            return decryptedMessage.toString();
        };

        return messageDecryptor.act(message, encryptionKey);
    }
}
