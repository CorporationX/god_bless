package school.faang.task_48899;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class Chore implements Runnable {
    static final int TIME_SLEEP = 3000;
    private String name;

    public Chore(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread name " + Thread.currentThread() + " " + name);
        try {
            System.out.println("Sleep");
            Thread.sleep(TIME_SLEEP);
            System.out.println("Wake up");
        } catch (InterruptedException e) {
            System.out.println("!!!Exception!!!" + e);
        }
    }
}
