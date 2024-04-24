package task12;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<String> messages = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            messages.add(String.valueOf(i));
        }
        Thread threadOne = new Thread(new SenderRunnable(messages, 0, 199));
        Thread threadTwo = new Thread(new SenderRunnable(messages, 200, 399));
        Thread threadThree = new Thread(new SenderRunnable(messages, 400, 599));
        Thread threadFour = new Thread(new SenderRunnable(messages, 600, 799));
        Thread threadFive = new Thread(new SenderRunnable(messages, 800, 199));
        threadOne.start();
        threadOne.join();
        threadTwo.start();
        threadTwo.join();
        threadThree.start();
        threadThree.join();
        threadFour.start();
        threadFour.join();
        threadFive.start();
        threadFive.join();
        System.out.println("Все сообщения отправлены");
    }
}