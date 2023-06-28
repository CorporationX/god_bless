package faang.school.godbless.Sprint_3.DroidSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
