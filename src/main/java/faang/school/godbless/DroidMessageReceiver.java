package faang.school.godbless;

@FunctionalInterface
public interface DroidMessageReceiver {
    public String decryptMessage(String encryptedMessage, Integer key);
}
