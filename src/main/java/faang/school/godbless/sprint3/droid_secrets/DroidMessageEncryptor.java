package faang.school.godbless.sprint3.droid_secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptMessage(String message, int key);
}
