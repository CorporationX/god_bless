package faang.school.godbless;
@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
