package faang.school.godbless.Task23_Droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    public String encrypt(String message, int key);
}
