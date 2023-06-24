package faang.school.godbless.droid.secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String cipher(String message, int key);
}
