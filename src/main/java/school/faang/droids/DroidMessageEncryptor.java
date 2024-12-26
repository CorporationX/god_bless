package school.faang.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
