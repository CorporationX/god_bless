package school.faang.functional_interface;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}