package school.faang.droid_secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String apply(String message, int encryptKey);
}
