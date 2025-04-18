package school.faang.stream2.drioidssecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String doCryptography(String message, int key);
}
