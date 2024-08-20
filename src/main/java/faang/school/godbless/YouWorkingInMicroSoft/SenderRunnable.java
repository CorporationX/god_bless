package faang.school.godbless.YouWorkingInMicroSoft;

import java.util.ArrayList;
import java.util.List;


public class SenderRunnable extends Thread implements Runnable {
    private final List<Integer> batch = new ArrayList<>();

    public SenderRunnable(int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            batch.add(MailSender.getLETTERS_IDS().get(i));
        }
    }

    @Override
    public void run() {
        batch.forEach(integer -> System.out.println("ОТПРАВЛЕНО ПиСЬМО С ID: " + integer));
        System.out.println("ПОТОК ОТРАБОТАЛ");
    }
}
