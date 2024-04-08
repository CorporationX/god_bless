package faang.school.godbless.DroidSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptionKey);
}
