package droidssecret;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String apply(String message, int key);
}
