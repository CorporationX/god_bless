package faang.school.godbless;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String messageEncrypt(String message, int key);
}
