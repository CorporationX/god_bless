package faang.school.godbless.droid_secrets;

public interface DroidMessageEncryptor<U, V> {
    String encrypt(U message, V key);
}
