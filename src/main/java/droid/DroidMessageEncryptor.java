package droid;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
