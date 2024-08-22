package faang.school.godbless.droid.secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptKey);
}
