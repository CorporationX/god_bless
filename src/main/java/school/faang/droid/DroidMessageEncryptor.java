package school.faang.droid;

public interface DroidMessageEncryptor {
    String massageEncrypt(String message, int key);

    default String massageDecrypt(String message, int key) {
        return massageEncrypt(message, -key);
    }
}