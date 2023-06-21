package faang.school.godbless.secondSprint.DroidSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
