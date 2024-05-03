package faang.school.godbless.youworkinmicrosoft;

import java.util.stream.Stream;

public class MainSender {
    public static void main(String[] args) {
        Stream.Builder<String> streamOfMailsBuilder = Stream.builder();
        for (int i = 1; i <= 1000; i++) {
            streamOfMailsBuilder.accept(String.format("\t\t\t\t\tThe mail № >>>  %d  <<<!", i));
        }
        var listOfMails = streamOfMailsBuilder.build().toList();
        var thread1 = new Thread(new SenderRunnable(0, 200, listOfMails));
        var thread2 = new Thread(new SenderRunnable(200, 400, listOfMails));
        var thread3 = new Thread(new SenderRunnable(400, 600, listOfMails));
        var thread4 = new Thread(new SenderRunnable(600, 800, listOfMails));
        var thread5 = new Thread(new SenderRunnable(800, 1000, listOfMails));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
