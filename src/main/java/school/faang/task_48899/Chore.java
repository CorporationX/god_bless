package school.faang.task_48899;

import lombok.ToString;

@ToString
public class Chore implements Runnable {
    private final String name;

    public Chore(String chore) {
        this.name = chore;
    }

    @Override
    public void run() {
        System.out.println("Thread name " + Thread.currentThread() + " " + name);
        try {
            System.out.println("Sleep");
            Thread.sleep(3000);
            System.out.println("Wake up");
        } catch (InterruptedException e) {
            System.out.println("!!!Exception!!!" + e);
        }
    }
}
