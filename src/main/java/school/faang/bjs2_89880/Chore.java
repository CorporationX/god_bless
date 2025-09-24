package school.faang.bjs2_89880;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(1000);
            System.out.println(chore + " - выполнено.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
