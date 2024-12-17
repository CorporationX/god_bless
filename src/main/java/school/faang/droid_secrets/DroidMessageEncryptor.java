package school.faang.droid_secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String use(String message, int key);
}
