package droidSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, Integer encryptionKey);
}
