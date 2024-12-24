package school.faang.task_48531;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Chore implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(Chore.class.getName());
    private static final int SLEEP_TIME = 3000;
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "выполняет задачу " + chore);
        try {
            Thread.sleep(SLEEP_TIME);
            System.out.println("Задача выполненена!");
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "поток прерван на задаче" + chore, e);
            Thread.currentThread().interrupt();
        }
    }
}
