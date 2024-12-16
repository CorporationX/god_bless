package school.faang.sprint_2.task_46185;

@FunctionalInterface
public interface MessageDecryptor {
    String decrypt(String message, int key);
}
