package school.faang.sprint_2.secretOfDroid;

@FunctionalInterface
public interface DroidMessageEncryptor<String, Integer> {
    String encrypt(String message, Integer key);
}
