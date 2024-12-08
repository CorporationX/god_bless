package school.faang.task_46184secretsdroid;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String execute(String message, int key);
}
