package faang.school.godbless.task24;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
