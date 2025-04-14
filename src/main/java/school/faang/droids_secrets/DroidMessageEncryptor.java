package school.faang.droids_secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptMessage(String message, int encryptionKey);
}
