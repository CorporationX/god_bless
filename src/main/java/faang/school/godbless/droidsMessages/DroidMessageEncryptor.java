package faang.school.godbless.droidsMessages;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptMessage(String message, int key);
}
