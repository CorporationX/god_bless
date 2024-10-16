package school.faang.BJS2_36779;

import lombok.Data;

import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class Chore implements Runnable {
    private String chore;
    private int time;
    private static final Logger logger = Logger.getLogger(Chore.class.getName());

    public Chore(String chore, int time) {
        this.chore = chore;
        this.time = time * 1000;
    }

    @Override
    public void run() {
        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + " выполниться через: " + time / 1000 + " секунд");
            Thread.sleep(time);
            System.out.println(chore + " ---  завершено");
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Задача: " + chore +  " прервана",e);
        }
    }
}
