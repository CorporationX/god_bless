package faang.school.godbless.kxnvg.starwars;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String encryption(String message, int key);
}
