package school.faang;

@FunctionalInterface
public interface DroidMessageEncryptor<U, V, R> {
    R apply(U p1, V p2);
}
