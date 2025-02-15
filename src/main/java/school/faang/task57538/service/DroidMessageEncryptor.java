package school.faang.task57538.service;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, Integer key);
}
