package school.faang.BJS2_37822;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MailSender {
    public static void main(String[] args) {

        CopyOnWriteArrayList<Message> msgList = new CopyOnWriteArrayList<>();
        List<Thread> msgGeneratorThreads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int threadNumber = i;
            msgGeneratorThreads.add(new Thread(() -> {
                for (int j = 0; j < 200; j++) {
                    msgList.add(new Message("MSG added in thread " + threadNumber,
                            StringGenerator.generateString(20)));
                }
            }));
            msgGeneratorThreads.get(i).start();
        }

        for (Thread thread : msgGeneratorThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (Message msg : msgList) {
            System.out.println(msg.toString());
        }
        System.out.println(msgList.size());

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SenderRunnable sender = new SenderRunnable(msgList,200 * i, 200 * (i + 1) - 1);
            threads.add(new Thread(sender));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Sending finished");
    }
}
