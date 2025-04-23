package school.faang.secret_droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String messageEncryptor(String message, Integer key);
}
