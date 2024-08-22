package faang.school.godbless.DroidSecret;

public class Droid {
    public void sendEncryptedMessage(Droid droid, String message, int key) {
        String encryptedMessage = DroidCrypto.encryptor.encrypt(message, key);

        System.out.println("Encrypted message: " + encryptedMessage);

        droid.receiveEncryptedMessage(encryptedMessage, key);
    }

    public void receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageReceiver droidMessageReceiver = new DroidMessageReceiver();
        String decryptedMessage = droidMessageReceiver.receiveEncryptedMessage(encryptedMessage, key);

        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
