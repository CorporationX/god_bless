package school.faang.task_57568;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String processing(String message, int key);
}
