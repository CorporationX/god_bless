package faang.school.godbless.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String crypt(String message, int key);
}
