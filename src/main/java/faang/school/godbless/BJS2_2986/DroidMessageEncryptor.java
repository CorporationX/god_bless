package faang.school.godbless.BJS2_2986;

//@FunctionalInterface
public interface DroidMessageEncryptor {
    void encrypt();

    default String encryptionHelper(String message, Integer encryptionKey){
        var sb = new StringBuilder();
        for (var chr : message.chars().toArray()) {
            sb.append((char) (chr + encryptionKey));
        }
        return sb.toString();
    }
}
