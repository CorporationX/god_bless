package faang.school.godbless.aged777_BJS2_9031_secrets_of_the_droids;

@FunctionalInterface
public interface DroidMessageEncryptor<String, Integer> {
    String encrypt(String message, Integer key);
}
