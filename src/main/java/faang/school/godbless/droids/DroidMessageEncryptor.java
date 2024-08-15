package faang.school.godbless.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String string, int key);
}
