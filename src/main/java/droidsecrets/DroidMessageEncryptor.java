package droidsecrets;

public interface DroidMessageEncryptor {
    String encryptAndDecrypt(String message, int encryptKey);
}
