package faang.school.godbless.droids_secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
