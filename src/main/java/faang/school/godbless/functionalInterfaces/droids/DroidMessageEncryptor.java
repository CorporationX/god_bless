package faang.school.godbless.functionalInterfaces.droids;

import java.util.function.BiFunction;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptMessage(String message, int encryptionKey, BiFunction<Integer, Integer, Character> operation);
}
