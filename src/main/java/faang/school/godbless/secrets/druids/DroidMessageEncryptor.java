package faang.school.godbless.secrets.druids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String messageEncryptor(String str, int key);
}
