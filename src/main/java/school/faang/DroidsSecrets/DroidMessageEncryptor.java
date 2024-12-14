package school.faang.DroidsSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String act(String message, int key);
}
