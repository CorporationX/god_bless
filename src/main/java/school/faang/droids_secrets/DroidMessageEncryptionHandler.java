package school.faang.droids_secrets;

@FunctionalInterface
public interface DroidMessageEncryptionHandler {
    String handleMessageEncryption(String message, int encryptionKey);
}
