package faang.school.godbless.Sprint_3.Lambda.DroidSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
