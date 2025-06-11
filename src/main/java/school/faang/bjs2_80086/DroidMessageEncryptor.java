package school.faang.bjs2_80086;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
