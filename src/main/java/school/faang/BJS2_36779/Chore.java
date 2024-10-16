package school.faang.BJS2_36779;

import lombok.Data;

@Data
public class Chore implements Runnable {
    private String chore;
    private int time;

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
            System.out.println(chore);
        }
    }
}
