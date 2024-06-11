package faang.school.godbless.starwars;

/**
 * @author Evgenii Malkov
 */
public interface DroidMessageEncryptor {
  String encrypt(String msg, int key);
}
