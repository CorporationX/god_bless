package derschrank.sprint04.task23.bjstwo_51054;

public interface Base extends Runnable {
    void sendMessage(Base destinationBase, String message);

    void receiveMessage(String encryptedMessage);

    void stop();

    void checkNewMessages();

    void outPutMessage(String message);
}
