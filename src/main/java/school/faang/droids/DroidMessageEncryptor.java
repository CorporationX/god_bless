package school.faang.droids;

@FunctionalInterface
public interface DroidMessageEncryptor<T> {
    T processCode(String string, Integer code);
}
