package school.faang.task_46320;

@FunctionalInterface
interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
