package school.faang.droidsecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptDroidMessage(String message, int encryptionKey);
}
