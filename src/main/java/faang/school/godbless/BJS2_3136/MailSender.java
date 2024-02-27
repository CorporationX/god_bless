package faang.school.godbless.BJS2_3136;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        var messageList = createMessages(1000);
        var threadList = new ArrayList<Thread>(5);
        for (int i = 0; i < 1000; i += 200){
            Thread newThread = new Thread(new SenderRunnable(i, i+200, messageList));
            newThread.start();
            threadList.add(newThread);
        }
        for (var thread: threadList){
            thread.join();
        }
        System.out.println("Main thread finished");
    }

    static List<Message> createMessages(int n) {
        var messageList = new ArrayList<Message>(n);
        for (int i = 0; i < n; ++i) {
            messageList.add(new Message(i));
        }
        return messageList;
    }
}
