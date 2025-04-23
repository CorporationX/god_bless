package school.faang.bjs2_70458;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String process(String message, int decipherKey);
}
