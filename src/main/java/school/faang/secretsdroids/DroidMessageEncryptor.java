package school.faang.secretsdroids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String makeEncrypting(String message, int number);
}