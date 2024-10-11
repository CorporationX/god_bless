package school.faang.secretsdroid;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String crypto(String message, Integer key);
}