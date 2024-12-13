package school.faang.sprint2.bjs_46216;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Droid(String name) {
    private static final int ALPHABET_SIZE = 26;

    public void sendMessage(Droid toDroid, String msg, int key) {
        log.info("Droid {} sent message: {}", name, msg);
        String encryptedMsg = encryptMessage(msg, key);
        toDroid.receiveMessage(encryptedMsg, key);
    }

    public void receiveMessage(String msg, int key) {
        log.info("I'm droid {}, received message: {}", name, msg);
        String decryptedMsg = decryptMessage(msg, key);
        log.info("Decrypted message: {}", decryptedMsg);
    }

    private String encryptMessage(String message, int encryptKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> encryption(msg, ALPHABET_SIZE - key);
        return encryptor.encrypt(message, encryptKey);
    }

    private String decryptMessage(String message, int decryptKey) {
        DroidMessageEncryptor encryptor = this::encryption;
        return encryptor.encrypt(message, decryptKey);
    }

    private String encryption(String message, int key) {
        StringBuilder encryptedMsg = new StringBuilder();
        for (char symbol : message.toCharArray()) {
            if (Character.isLetter(symbol)) {
                char startLetter = Character.isUpperCase(symbol) ? 'A' : 'a';
                encryptedMsg.append((char) ((symbol - startLetter + key) % ALPHABET_SIZE + startLetter));
            } else {
                encryptedMsg.append(symbol);
            }
        }
        return encryptedMsg.toString();
    }
}
