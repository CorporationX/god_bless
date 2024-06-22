package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MailSender {
    public static void main(String[] args) {
        sendMail(IntStream.range(0, 1001).boxed().map(String::valueOf).toList(), 5);

//        This is here because im a little confused about thread join and how threads await eachother
//        So the current running code is being awaited, commented code is awaited as well
//        However in the task it says that i need to use join for thread to wait for it to finish
//        If the thread is makred as deamon then join is required
//
//        List<String> list = IntStream.range(0, 1001).boxed().map(String::valueOf).toList();
//        Thread thread1 = new Thread(new SenderRunnable(0,200, list));
//        Thread thread2 = new Thread(new SenderRunnable(201,400, list));
//        Thread thread3 = new Thread(new SenderRunnable(401,600, list));
//        Thread thread4 = new Thread(new SenderRunnable(601,800, list));
//        Thread thread5 = new Thread(new SenderRunnable(801,1000, list));
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
    }

    public static void sendMail(List<String> list, int threadsNumber) {
        int messageQueueSize = list.size();
        int batchSize = messageQueueSize / threadsNumber;
        for (int i = 0; i < messageQueueSize/batchSize; i++) {
            Thread thread = new Thread(new SenderRunnable(i * batchSize, (i+1) * batchSize, list));
            thread.setName(String.valueOf(i));
            thread.start();
        }
    }
}
