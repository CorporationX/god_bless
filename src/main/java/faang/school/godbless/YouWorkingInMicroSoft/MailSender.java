package faang.school.godbless.YouWorkingInMicroSoft;

import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

public class MailSender {
    @Getter
    private static final List<Integer> LETTERS_IDS = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            LETTERS_IDS.add(i);
        }

        SenderRunnable senderRunnableFirst = new SenderRunnable(0, 200);
        SenderRunnable senderRunnableSecond = new SenderRunnable(200, 400);
        SenderRunnable senderRunnableThird = new SenderRunnable(400, 600);
        SenderRunnable senderRunnableFourth = new SenderRunnable(600, 800);
        SenderRunnable senderRunnableFifth = new SenderRunnable(800, 1000);

        senderRunnableFirst.start();
        senderRunnableSecond.start();
        senderRunnableThird.start();
        senderRunnableFourth.start();
        senderRunnableFifth.start();

        try {
            senderRunnableFirst.join();
            senderRunnableSecond.join();
            senderRunnableThird.join();
            senderRunnableFourth.join();
            senderRunnableFifth.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ВСЁ УСПЕШНО ОТПРАВЛЕНО");
    }
}
