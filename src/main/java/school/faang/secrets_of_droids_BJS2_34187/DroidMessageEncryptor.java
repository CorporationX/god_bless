package school.faang.secrets_of_droids_BJS2_34187;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptionKey);
}
