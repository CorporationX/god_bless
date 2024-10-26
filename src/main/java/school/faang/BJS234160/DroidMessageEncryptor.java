package school.faang.BJS234160;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String message(String line, int key);
}
