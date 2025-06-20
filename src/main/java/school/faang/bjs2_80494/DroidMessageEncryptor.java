package school.faang.bjs2_80494;

@FunctionalInterface
public interface DroidMessageEncryptor<T> {
    String apply(String message, int keyEncryption);
}
