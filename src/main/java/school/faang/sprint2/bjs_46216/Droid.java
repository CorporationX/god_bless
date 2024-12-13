package school.faang.sprint2.bjs_46216;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Droid {
    private final String name;

    public Droid(String name) {
        this.name = name;
    }

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

    public String encryptMessage(String message, int encryptKey) {
        boolean flag = true;
        DroidMessageEncryptor encryptor = (msg, key) -> encryption(msg, key, flag);
        return encryptor.encrypt(message, encryptKey);
    }

    public String decryptMessage(String message, int decryptKey) {
        boolean flag = false;
        DroidMessageEncryptor encryptor = (msg, key) -> encryption(msg, key, flag);
        return encryptor.encrypt(message, decryptKey);
    }

    private String encryption(String message, int key, boolean flag) {
        int dop = flag ? key : (26 - key);
        StringBuilder encryptedMsg = new StringBuilder();
        for (char symbol : message.toCharArray()) {
            if (Character.isLetter(symbol)) {
                char startLetter = Character.isUpperCase(symbol) ? 'A' : 'a';
                encryptedMsg.append((char) ((symbol - startLetter + dop) % 26 + startLetter));
            } else {
                encryptedMsg.append(symbol);
            }
        }
        return encryptedMsg.toString();
    }
}
