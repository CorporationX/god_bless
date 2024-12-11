package school.faang.bjs246209;

@FunctionalInterface
public interface DroidMessageDecryptor<U, V, R> {
    R apply(U message, V key);
}