package school.faang.lambda.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String transform(String message, int key);
}
