package school.faang.droidsecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String process(String message, int key);
}
