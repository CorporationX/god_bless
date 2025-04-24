package school.faang.droid_secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String translate(String message, int encryptionKey);
}