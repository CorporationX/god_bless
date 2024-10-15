package school.faang.droidssecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String apply(String message, int key);
}