package school.faang.task_46191;

import java.util.Base64;

public class Droid {
    private final String name;

    public Droid(String name) {
        this.name = name;
    }

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            String combiningMessage = msg + k;
            return Base64.getEncoder().encodeToString(combiningMessage.getBytes());
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        byte[] decodedMessageBytes = Base64.getDecoder().decode(message);
        String decodedMessage = new String(decodedMessageBytes);

        return decodedMessage.substring(0, decodedMessage.length() - String.valueOf(key).length());
    }

    public void sendMessage(Droid recipient, String message, int key) {
        String encrMessage = encryptMessage(message, key);
        System.out.println(this.name + " отправил сообщение : " + encrMessage);
        recipient.returnMessage(encrMessage, key);
    }

    public void returnMessage(String message, int key) {
        String decrMessage = decryptMessage(message, key);
        System.out.println(this.name + " получил сообщение " + decrMessage);
    }
}
