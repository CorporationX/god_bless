package school.faang.BJS2_36779;

import lombok.Data;

@Data
public class Chore implements Runnable {
    private String chore;
    private int time;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + " выполниться через: " + 30 + " секунд");
            Thread.sleep(30000);
            System.out.println(chore + " ---  завершино");
        } catch (InterruptedException e) {
            System.out.println(chore + " --- в другой раз");
        }
    }
}
