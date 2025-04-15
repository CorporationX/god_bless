package school.faang.bjs2_72002;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptionKey);
}
