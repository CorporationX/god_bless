package faang.school.godbless.droid_secret;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
