package school.faang.bjs246440;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
