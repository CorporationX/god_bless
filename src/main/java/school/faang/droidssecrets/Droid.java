package school.faang.droidssecrets;

import java.util.List;

public class Droid {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private final String name;
    private DroidMessageEncryptor droidMessageEncryptor;

    public Droid(String name) {
        this.name = name;
    }

    private String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (int i=0; i< message.length(); i++) {

            }
            System.out.println(encryptedMessage);
            return encryptedMessage.toString();
        };
        return droidMessageEncryptor.processMessage(message, encryptionKey);
    }

    public void sendMessage(Droid droidRecipient, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        droidRecipient.receiveMessage(encryptedMessage, encryptionKey);
    }

    private void receiveMessage(String encryptedMessage, int encryptionKey) {

    }

}
