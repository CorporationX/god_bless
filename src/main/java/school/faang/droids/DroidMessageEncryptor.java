package school.faang.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String translate(String message, int key);
}
