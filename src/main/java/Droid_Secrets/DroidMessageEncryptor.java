package Droid_Secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptMessage(String message, int key);
}
