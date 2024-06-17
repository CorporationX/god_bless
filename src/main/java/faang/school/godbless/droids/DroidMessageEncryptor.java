package faang.school.godbless.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    public String encrypt(String message,int hash);
}
