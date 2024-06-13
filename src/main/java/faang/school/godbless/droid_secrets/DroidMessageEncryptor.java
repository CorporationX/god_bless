package faang.school.godbless.droid_secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String crypt(String message, int key);
}
