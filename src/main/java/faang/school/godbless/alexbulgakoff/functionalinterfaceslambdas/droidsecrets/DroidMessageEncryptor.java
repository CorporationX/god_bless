package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.droidsecrets;

/**
 * @author Alexander Bulgakov
 */
@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptor(String message, int key);
}
