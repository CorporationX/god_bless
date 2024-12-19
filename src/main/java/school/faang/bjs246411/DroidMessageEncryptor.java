package school.faang.bjs246411;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}