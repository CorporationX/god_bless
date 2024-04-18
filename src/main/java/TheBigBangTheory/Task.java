package TheBigBangTheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начал выполнять задание " + task);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println(name + " выполнил задание!");
    }
}
