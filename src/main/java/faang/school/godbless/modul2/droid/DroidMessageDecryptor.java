package faang.school.godbless.modul2.droid;

@FunctionalInterface
public interface DroidMessageDecryptor {
    String decrypt(String message, int key);
}
