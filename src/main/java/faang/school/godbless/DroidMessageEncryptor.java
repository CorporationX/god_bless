package faang.school.godbless;

@FunctionalInterface
public interface DroidMessageEncryptor {
    public String encrypt(String message,Integer key);
}
