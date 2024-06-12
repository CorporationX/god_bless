package faang.school.godbless.lambda;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String encryptor(String message, Integer key);
}
