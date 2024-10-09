package school.faang.droidsecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
