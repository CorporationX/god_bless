package school.faang.secret_droids;

@FunctionalInterface
public interface DroidMessageEncryptor<T, V> {
    T messageEncryptor(T message, V key);
}
