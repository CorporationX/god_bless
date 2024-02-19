package faang.school.godbless.star_wars;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
