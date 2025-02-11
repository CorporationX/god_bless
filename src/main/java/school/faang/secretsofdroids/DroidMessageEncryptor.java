package school.faang.secretsofdroids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String change(String message, int encryptionKey);
}
