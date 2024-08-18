package faang.school.godbless.droidsMessages;

public class DroidMessageReceiver {
    public static void receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> CaesarCipher.code(m, -k);
        String decryptedMessage = droidMessageEncryptor.encryptMessage(message, key);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}