package secretsofthedroids;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String encrypt(String message, int encryptionKey);
}
