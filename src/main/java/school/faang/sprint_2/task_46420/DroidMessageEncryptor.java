package school.faang.sprint_2.task_46420;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String process(String message, int key);
}
