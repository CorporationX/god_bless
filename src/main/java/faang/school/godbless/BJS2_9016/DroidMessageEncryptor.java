package faang.school.godbless.BJS2_9016;

import java.util.function.BiFunction;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String crypt(String message, int crypt_key, BiFunction<String, Integer, String> cryptOperation);
}
