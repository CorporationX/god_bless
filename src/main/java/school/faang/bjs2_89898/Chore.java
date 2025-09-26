package school.faang.bjs2_89898;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Поток " + name + " начал задачу: " + chore);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " прервана");
            return;
        }
        System.out.println("Поток " + name + " закончил задачу: " + chore);
    }
}
