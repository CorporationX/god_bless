package school.faang.bjs2_70485;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String get(String message, int key);
}
