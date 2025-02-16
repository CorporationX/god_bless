package school.faang.task57776.droid;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
