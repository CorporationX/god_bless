package school.faang.sprint.second.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
