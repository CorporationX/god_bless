package faang.school.godbless.BJS2_20971;

@FunctionalInterface
public interface DroidMessageDecoder {
    String decode(String message, int encryptionKey);
}
