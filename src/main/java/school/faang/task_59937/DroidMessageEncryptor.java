package school.faang.task_59937;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String messageCryptoAlgorithm(String message, int encryptionKey);
}
