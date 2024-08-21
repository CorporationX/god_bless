package BJS2_20975_DroidsSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int cypherKey);
}
