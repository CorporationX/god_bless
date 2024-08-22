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

        List<SenderRunnable> senderRunnables = new ArrayList<>();

        SenderRunnable senderRunnableFirst = new SenderRunnable(0, 200);
        senderRunnables.add(senderRunnableFirst);
        SenderRunnable senderRunnableSecond = new SenderRunnable(200, 400);
        senderRunnables.add(senderRunnableSecond);
        SenderRunnable senderRunnableThird = new SenderRunnable(400, 600);
        senderRunnables.add(senderRunnableThird);
        SenderRunnable senderRunnableFourth = new SenderRunnable(600, 800);
        senderRunnables.add(senderRunnableFourth);
        SenderRunnable senderRunnableFifth = new SenderRunnable(800, 1000);
        senderRunnables.add(senderRunnableFifth);

        senderRunnables.forEach(SenderRunnable::run);

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
