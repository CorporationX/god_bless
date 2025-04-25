package BJS2_70403;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String accept(String message, int key);
}
