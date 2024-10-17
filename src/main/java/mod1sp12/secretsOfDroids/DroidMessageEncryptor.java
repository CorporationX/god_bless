package mod1sp12.secretsOfDroids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String str, int encryptionKey);
}