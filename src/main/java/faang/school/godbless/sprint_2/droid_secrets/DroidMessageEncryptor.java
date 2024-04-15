package faang.school.godbless.sprint_2.droid_secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}