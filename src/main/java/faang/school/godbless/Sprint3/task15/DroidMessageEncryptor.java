package faang.school.godbless.Sprint3.task15;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
