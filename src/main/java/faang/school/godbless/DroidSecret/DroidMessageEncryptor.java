package faang.school.godbless.DroidSecret;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}

