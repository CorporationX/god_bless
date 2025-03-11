package school.faang.droid_secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptKey);
    String decrypt(String message, int encryptKey);
}
