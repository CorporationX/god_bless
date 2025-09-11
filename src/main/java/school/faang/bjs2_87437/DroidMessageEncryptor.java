package school.faang.bjs2_87437;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String cipher(String message, int key);
}
