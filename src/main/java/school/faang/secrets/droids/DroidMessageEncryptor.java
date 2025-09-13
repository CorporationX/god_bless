package school.faang.secrets.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
