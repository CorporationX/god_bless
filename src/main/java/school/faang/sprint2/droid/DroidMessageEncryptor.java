package school.faang.sprint2.droid;
@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
