package school.faang.sprint2.task47010.service;

public class SmsService implements Sender {
    public void sendMessage(String message) {
        System.out.println(">>Message was sent by SMS channel");
        System.out.println("SMS: " + message);
        System.out.println("----");
    }
}
