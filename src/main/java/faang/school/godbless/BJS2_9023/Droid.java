package faang.school.godbless.BJS2_9023;

public class Droid {
    private String message;
    private int key;

    DroidMessageEncryptor encryptor;
    DroidMessageEncryptor decryptor;

    public Droid() {
        encryptor = (message, key) -> {
            StringBuilder builder = new StringBuilder();
            for (Character character : message.toCharArray()) {
                builder.append((char)(character - key));
            }
            return builder.toString();
        };

        decryptor = (message, key) -> {
            StringBuilder builder = new StringBuilder();
            for (Character character : message.toCharArray()) {
                builder.append((char)(character + key));
            }
            return builder.toString();
        };
    }

    public String sendEncryptedMessage(String message, int encryptionKey) {
        return encryptor.encryptMessage(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMsg, int encryptionKey) {
        return decryptor.encryptMessage(encryptedMsg, encryptionKey);
    }

}
