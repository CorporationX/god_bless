package faang.school.godbless.sprint2.droidSecret;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptor(String message, int key);
}
