package secretsOfDroids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String str, int encryptionKey);
}