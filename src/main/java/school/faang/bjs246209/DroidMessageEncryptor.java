package school.faang.bjs246209;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String apply(String message, int key);
}
