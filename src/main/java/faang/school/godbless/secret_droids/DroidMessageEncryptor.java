package faang.school.godbless.secret_droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypting (String message, int password);
}
