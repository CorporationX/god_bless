package school.faang.sprint2.task_7;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
