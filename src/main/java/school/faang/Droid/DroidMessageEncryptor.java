package school.faang.Droid;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String apply(String message, int key);
}
