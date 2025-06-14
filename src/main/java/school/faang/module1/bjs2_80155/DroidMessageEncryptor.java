package school.faang.module1.bjs2_80155;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String transformMessage(String message, int key);
}