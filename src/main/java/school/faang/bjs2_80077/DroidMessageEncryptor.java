package school.faang.bjs2_80077;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
