package school.faang.bjs2_80117;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
