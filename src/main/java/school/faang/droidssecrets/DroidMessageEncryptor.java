package school.faang.droidssecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String processMessage(String message, int key);
}
