package school.faang.droidssecters;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptionKey, boolean isEncrypt);
}