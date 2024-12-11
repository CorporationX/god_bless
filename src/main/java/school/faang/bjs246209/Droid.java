package school.faang.bjs246209;

public class Droid {
    private final String name;
    private DroidMessageDecryptor <String, Integer, String> decryptor = (msg, key) -> {
        return msg+key;
    };

    public Droid(String name) {
        this.name = name;
    }

    public void sendMessage(Droid droid, String message, int encryptionKey){
        DroidMessageEncryptor encryptor = (msg, key) -> {

            return msg + key; // Example encryption logic
        };

        String encryptedMessage = encryptor.apply(message, encryptionKey);

        receiveMessage(droid, encryptedMessage, encryptionKey);
    }

    public void receiveMessage(Droid droid, String message, int encryptionKey){
        String decryptedMessage = decryptor.apply(message, encryptionKey);

    }

}
