package faang.school.godbless.Droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    public String encrypt(String message, int key);
}
