package school.faang.bjs2_57457;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String apply(String message, int key);
}