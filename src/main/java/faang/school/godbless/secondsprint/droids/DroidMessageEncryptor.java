package faang.school.godbless.secondsprint.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
