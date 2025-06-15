package school.faang.bjs2_80126;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
