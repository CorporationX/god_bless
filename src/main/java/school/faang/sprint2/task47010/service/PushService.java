package school.faang.sprint2.task47010.service;

public class PushService implements Sender {
    public void sendMessage(String message) {
        System.out.println(">>Message was sent like a Push message");
        System.out.println("Push: " + message);
        System.out.println("----");
    }
}
