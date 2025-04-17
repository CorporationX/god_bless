package school.faang.bjs2_70389;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}