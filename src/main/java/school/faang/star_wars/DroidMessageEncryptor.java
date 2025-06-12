package school.faang.star_wars;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptorKey);
}
