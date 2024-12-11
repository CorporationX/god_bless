package school.faang.bjs246232;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
