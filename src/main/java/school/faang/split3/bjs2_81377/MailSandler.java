package school.faang.split3.bjs2_81377;

import java.util.ArrayList;
import java.util.List;

public class MailSandler {
    public static void main(String[] args) {
        List<Thread> sendersThread = new ArrayList<>();
        for (int i = 1; i <= 801; i += 200) {
            Thread thread = new Thread(new SandlerRunnable(i, i + 199));
            sendersThread.add(thread);
            thread.start();
        }

        try {
            for (Thread thread : sendersThread) {
                thread.join();
            }
            System.out.println("Все письма отправленны");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ожидание было прервано");
        }
    }
}