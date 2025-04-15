package school.faang.encryption;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
