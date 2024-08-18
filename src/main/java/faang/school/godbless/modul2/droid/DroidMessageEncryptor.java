package faang.school.godbless.modul2.droid;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
