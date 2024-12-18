package school.faang.task_46441;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String shift(String message, int key);
}
