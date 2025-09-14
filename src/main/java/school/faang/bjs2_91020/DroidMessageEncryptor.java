package school.faang.bjs2_91020;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String process(String message, int key);
}
