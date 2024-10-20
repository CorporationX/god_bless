package school.faang.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String funcEncryption(String string, int key);
}
