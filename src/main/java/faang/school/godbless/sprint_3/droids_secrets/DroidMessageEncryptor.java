package faang.school.godbless.sprint_3.droids_secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String stroke, int key);
}
