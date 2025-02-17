package bjs260443;

import java.util.List;
import java.util.stream.IntStream;

public class MailSender {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(0, 1000).sorted().boxed().toList();
        SenderRunnable firstSenderRunnable = new SenderRunnable(numbers.get(0), numbers.get(199));
        SenderRunnable secondSenderRunnable = new SenderRunnable(numbers.get(200), numbers.get(399));
        SenderRunnable thirdSenderRunnable = new SenderRunnable(numbers.get(400), numbers.get(599));
        SenderRunnable fourthSenderRunnable = new SenderRunnable(numbers.get(600), numbers.get(799));
        SenderRunnable fifthSenderRunnable = new SenderRunnable(numbers.get(800), numbers.get(999));
        List<Thread> startedThreads = getStartedThreads(firstSenderRunnable, secondSenderRunnable, thirdSenderRunnable,
                fourthSenderRunnable, fifthSenderRunnable);
        startedThreads.forEach(startedThread -> {
            try {
                startedThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread " + startedThread.getName() + "has interrupted", e);
            }
        });
        System.out.println("All threads have finished");
    }

    private static List<Thread> getStartedThreads(SenderRunnable firstSenderRunnable,
                                                  SenderRunnable secondSenderRunnable,
                                                  SenderRunnable thirdSenderRunnable,
                                                  SenderRunnable fourthSenderRunnable,
                                                  SenderRunnable fifthSenderRunnable) {
        Thread firstThread = new Thread(firstSenderRunnable, "firstThread");
        firstThread.start();
        Thread secondThread = new Thread(secondSenderRunnable, "secondThread");
        secondThread.start();
        Thread thirdThread = new Thread(thirdSenderRunnable, "thirdThread");
        thirdThread.start();
        Thread fourthThread = new Thread(fourthSenderRunnable, "fourthThread");
        fourthThread.start();
        Thread fifthThread = new Thread(fifthSenderRunnable, "fifthThread");
        fifthThread.start();
        return List.of(firstThread, secondThread, thirdThread, fourthThread, fifthThread);
    }
}
