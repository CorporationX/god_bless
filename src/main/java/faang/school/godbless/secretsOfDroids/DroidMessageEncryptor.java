package faang.school.godbless.secretsOfDroids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
