package school.faang.sprint2.task46300.model;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}