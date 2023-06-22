package faang.school.godbless.droid;

@FunctionalInterface
public interface DroidMessageEncryptor {
  public String encrypt(String message, int key);
}
