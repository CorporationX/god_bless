package faang.school.godbless.done.droid.secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String mess, int key);
}
