package faang.school.godbless.microsoft.outlook;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MainSender {
    private static final int TOTAL_NUMBER_OF_LETTERS = 1000;
    private static final int NUMBER_IN_BUNCH_OF_LETTER = 200;

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < TOTAL_NUMBER_OF_LETTERS; i += NUMBER_IN_BUNCH_OF_LETTER) {
            threads.add(new Thread(new SenderRunnable(i, i + NUMBER_IN_BUNCH_OF_LETTER)));
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("All messages have just sent");
        } catch (InterruptedException exception) {
            log.error("An error occurred while sending the emails", exception);
        }
    }
}
