package faang.school.godbless.lambdas.task_11.model;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
