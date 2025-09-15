package school.faang.bjs2_88877;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String processMessage(String message, int key);
}