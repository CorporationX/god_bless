package school.faang;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
