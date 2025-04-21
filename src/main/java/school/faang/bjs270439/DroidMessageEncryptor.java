package school.faang.bjs270439;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String encrypt(String message, int key);
}