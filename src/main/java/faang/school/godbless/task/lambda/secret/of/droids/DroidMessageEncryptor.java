package faang.school.godbless.task.lambda.secret.of.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptionKey);
}
