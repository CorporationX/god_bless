package school.faang.sprint_2.task_46252;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
