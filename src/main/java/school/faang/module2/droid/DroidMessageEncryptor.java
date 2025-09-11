package school.faang.module2.droid;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String crypt(String message, int key);
}
