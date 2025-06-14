package school.faang.bjs2_80202;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String apply(String message, int key);
}
