package bjs257422;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptOrDecryptMessage(String message, int key);
}
