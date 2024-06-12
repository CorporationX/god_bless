package faang.school.godbless.droid;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String apply(String message, int encryptionKey);
}
