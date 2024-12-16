package school.faang.bjs46298;

@FunctionalInterface
public interface DroidMessageEncryptor {
    public String encrypt(String original, int key);
}
