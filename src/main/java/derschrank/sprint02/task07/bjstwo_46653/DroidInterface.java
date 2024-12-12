package derschrank.sprint02.task07.bjstwo_46653;

public interface DroidInterface {
    String encryptMessage(String message, int key);

    String decryptMessage(String message, int key);

    void sendMessage(Droid destination, String message, int key);

    void receiveMessage(String message, int key);
}
