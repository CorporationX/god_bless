package school.faang.droid;


@FunctionalInterface
public interface DroidMessageEncryptor<String, Integer> {
    String encryption(String message, Integer key);
}
