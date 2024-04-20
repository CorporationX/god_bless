package droidsSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    public String encrypt(String message, int encryptionKey);
}
